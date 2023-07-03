package com.example.a1tutorial;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a1tutorial.dao.SensorDataViewModel;
import com.example.a1tutorial.entities.SensorDataEntity;


public class FeedbackFragment extends Fragment {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private SensorDataViewModel sensorDataViewModel;
    private TextView feedbackDataView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorDataViewModel = new ViewModelProvider(this).get(SensorDataViewModel.class);
        return inflater.inflate(R.layout.feedback_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        feedbackDataView = view.findViewById(R.id.textView);

        Bundle args = getArguments();
        FeedbackFragmentArgs navigationFragmentArgs = null;

        if (args != null) {
            navigationFragmentArgs = FeedbackFragmentArgs.fromBundle(args);
        }

        if (navigationFragmentArgs != null) {
            feedbackDataView.setText(navigationFragmentArgs.getFeedbackData());
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];
                SensorDataEntity sensorDataEntity = new SensorDataEntity(System.currentTimeMillis(), x, y, z);
                sensorDataViewModel.insert(sensorDataEntity);
                String text = String.format("X-Achse: %.2f\nY-Achse: %.2f\nZ-Achse: %.2f", x, y, z);
                feedbackDataView.setText(text);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
}
