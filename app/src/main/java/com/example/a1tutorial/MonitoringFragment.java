package com.example.a1tutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1tutorial.dao.SensorDataAdapter;
import com.example.a1tutorial.dao.SensorDataViewModel;

public class MonitoringFragment extends Fragment {
    private SensorDataAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monitoring_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        adapter = new SensorDataAdapter();
        recyclerView.setAdapter(adapter);

        SensorDataViewModel sensorDataViewModel = new ViewModelProvider(this).get(SensorDataViewModel.class);
        sensorDataViewModel.getAllSensorData().observe(getViewLifecycleOwner(), sensorData -> adapter.setSensorData(sensorData));
        return view;
    }
}
