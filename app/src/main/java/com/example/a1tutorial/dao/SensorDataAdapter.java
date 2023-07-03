package com.example.a1tutorial.dao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1tutorial.R;
import com.example.a1tutorial.entities.SensorDataEntity;

import java.util.ArrayList;
import java.util.List;

public class SensorDataAdapter extends RecyclerView.Adapter<SensorDataAdapter.SensorDataViewHolder> {
    private List<SensorDataEntity> sensorDataList = new ArrayList<>();

    @NonNull
    @Override
    public SensorDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_sensor_data, parent, false);
        return new SensorDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorDataViewHolder holder, int position) {
        SensorDataEntity currentSensorData = sensorDataList.get(position);
        holder.textViewX.setText(String.valueOf(currentSensorData.getX()));
        holder.textViewY.setText(String.valueOf(currentSensorData.getY()));
        holder.textViewZ.setText(String.valueOf(currentSensorData.getZ()));
    }

    @Override
    public int getItemCount() {
        return sensorDataList.size();
    }

    public void setSensorData(List<SensorDataEntity> sensorData) {
        this.sensorDataList = sensorData;
        notifyDataSetChanged();
    }

    static class SensorDataViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewX;
        private final TextView textViewY;
        private final TextView textViewZ;

        public SensorDataViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewX = itemView.findViewById(R.id.textViewX);
            textViewY = itemView.findViewById(R.id.textViewY);
            textViewZ = itemView.findViewById(R.id.textViewZ);
        }
    }
}
