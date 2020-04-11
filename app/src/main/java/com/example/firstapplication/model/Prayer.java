package com.example.firstapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "prayer_info")
public class Prayer {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int fajr;
    private int dhuhr;
    private int asr;
    private int maghrib;
    private int isha;

    public Prayer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFajr() {
        return fajr;
    }

    public void setFajr(int fajr) {
        this.fajr = fajr;
    }

    public int getDhuhr() {
        return dhuhr;
    }

    public void setDhuhr(int dhuhr) {
        this.dhuhr = dhuhr;
    }

    public int getAsr() {
        return asr;
    }

    public void setAsr(int asr) {
        this.asr = asr;
    }

    public int getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(int maghrib) {
        this.maghrib = maghrib;
    }

    public int getIsha() {
        return isha;
    }

    public void setIsha(int isha) {
        this.isha = isha;
    }
}
