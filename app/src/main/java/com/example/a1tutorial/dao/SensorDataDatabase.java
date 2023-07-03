package com.example.a1tutorial.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.a1tutorial.entities.SensorDataEntity;

@Database(entities = {SensorDataEntity.class}, version = 1)
public abstract class SensorDataDatabase extends RoomDatabase {
    private static SensorDataDatabase instance;

    public abstract SensorDataDao sensorDataDao();

    public static synchronized SensorDataDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            SensorDataDatabase.class, "sensor_data_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
