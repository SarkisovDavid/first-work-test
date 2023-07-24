package com.example.test.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historyBin2")
class CardEntity (
    @PrimaryKey val bin: String,
    val scheme: String,
    val type: String,
    val bankName: String,
    val timestamp: String
    ) {
    override fun toString(): String {
        return "CardEntity(bin='$bin', scheme='$scheme', type='$type', bankName='$bankName', timestamp='$timestamp')"
    }
}