package com.example.a1tutorial.dao;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.a1tutorial.entities.SensorDataEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SensorDataViewModel extends AndroidViewModel {
    private final SensorDataDao sensorDataDao;
    private final LiveData<List<SensorDataEntity>> allSensorData;
    private final ExecutorService databaseWriteExecutor;

    public SensorDataViewModel(@NonNull Application application) {
        super(application);
        SensorDataDatabase database = SensorDataDatabase.getInstance(application);
        sensorDataDao = database.sensorDataDao();
        allSensorData = sensorDataDao.getAllSensorData();
        databaseWriteExecutor = Executors.newSingleThreadExecutor();
    }

    public void insert(SensorDataEntity sensorDataEntity) {
        databaseWriteExecutor.execute(() -> sensorDataDao.insert(sensorDataEntity));
    }

    public LiveData<List<SensorDataEntity>> getAllSensorData() {
        return allSensorData;
    }
}
