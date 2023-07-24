package com.example.test.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test.data.model.CardEntity

@Database(entities = [CardEntity::class], version = 6, exportSchema = false)
abstract class BinDatabase : RoomDatabase() {

    companion object {

        private const val DB_NAME = "card2.db"

        @Volatile
        private var instance: BinDatabase? = null

        fun getInstance(context: Context): BinDatabase
        {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    BinDatabase::class.java,
                    DB_NAME).fallbackToDestructiveMigration().build()
            }
            return instance as BinDatabase
        }
    }

    abstract fun binDao(): BinDao
}