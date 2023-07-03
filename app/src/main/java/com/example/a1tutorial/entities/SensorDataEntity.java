package com.example.a1tutorial.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sensor_data")
public class SensorDataEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private final long timestamp;
    private final float x;
    private final float y;
    private final float z;

    public SensorDataEntity(long timestamp, float x, float y, float z) {
        this.timestamp = timestamp;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

}
