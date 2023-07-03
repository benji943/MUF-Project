package com.example.a1tutorial.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a1tutorial.entities.SensorDataEntity;

import java.util.List;

@Dao
public interface SensorDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SensorDataEntity sensorDataEntity);

    @Query("SELECT * FROM sensor_data order by id desc")
    LiveData<List<SensorDataEntity>> getAllSensorData();
}
