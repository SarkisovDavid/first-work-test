package com.example.test.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.test.data.model.CardEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface BinDao {

    @androidx.room.Query("SELECT * FROM historyBin2 ORDER BY timestamp DESC")
    fun getHistoryCardBin(): Single<List<CardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBin(cardEntity: CardEntity)
}