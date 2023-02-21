package com.example.test;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "historyBin2")
public class CardEntity {

    @PrimaryKey
    @NonNull
    private String bin;
    private String scheme;
    private String type;
    private String bankName;
    private String timestamp;

    public CardEntity(@NonNull String bin, String scheme, String type, String bankName, String timestamp) {
        this.bin = bin;
        this.scheme = scheme;
        this.type = type;
        this.bankName = bankName;
        this.timestamp = timestamp;
    }

    public String getBin() {
        return bin;
    }

    public String getScheme() {
        return scheme;
    }

    public String getType() {
        return type;
    }

    public String getBankName() {
        return bankName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "bin='" + bin + '\'' +
                ", scheme='" + scheme + '\'' +
                ", type='" + type + '\'' +
                ", bankName='" + bankName + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
