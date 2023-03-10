package com.example.test;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CardEntity.class}, version = 6, exportSchema = false)
public abstract class BinDatabase extends RoomDatabase {

    private static final String DB_NAME = "card2.db";
    private static BinDatabase instance = null;

    public static BinDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(application, BinDatabase.class, DB_NAME).build();
        }
        return instance;
    }
    abstract BinDao binDao();
}
