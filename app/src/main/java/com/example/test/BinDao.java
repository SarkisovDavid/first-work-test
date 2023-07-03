package com.example.test;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface BinDao {

    @Query("SELECT * FROM historyBin2 ORDER BY timestamp DESC")
    Single<List<CardEntity>> getHistoryCardBin();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBin(CardEntity cardEntity);
}
