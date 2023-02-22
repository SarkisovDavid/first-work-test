package com.example.test;

import com.google.gson.annotations.SerializedName;

public class Number {

    @SerializedName("length")
    private Integer length;
    @SerializedName("luhn")
    private Boolean luhn;

    public Number(int length, boolean luhn) {
        this.length = length;
        this.luhn = luhn;
    }

    public Integer getLength() {
        return length;
    }

    public Boolean isLuhn() {
        return luhn;
    }

    @Override
    public String toString() {
        return "Number{" +
                "length=" + length +
                ", luhn=" + luhn +
                '}';
    }
}
