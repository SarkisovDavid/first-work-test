package com.example.test.data.database;

import android.content.Context;

import com.example.test.data.model.CardEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CardEntity.class}, version = 6, exportSchema = false)
public abstract class BinDatabase extends RoomDatabase {

    private static final String DB_NAME = "card2.db";
    private static BinDatabase instance = null;

    public static BinDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, BinDatabase.class, DB_NAME).build();
        }
        return instance;
    }
    public abstract BinDao binDao();
}
