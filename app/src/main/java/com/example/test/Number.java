package com.example.test;

import com.google.gson.annotations.SerializedName;

public class Number {

    @SerializedName("length")
    private int length;
    @SerializedName("luhn")
    private boolean luhn;

    public Number(int length, boolean luhn) {
        this.length = length;
        this.luhn = luhn;
    }

    public int getLength() {
        return length;
    }

    public boolean isLuhn() {
        return luhn;
    }
}
