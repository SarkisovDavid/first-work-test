package com.example.test.data.model;

import com.google.gson.annotations.SerializedName;

public class NumberDto {

    @SerializedName("length")
    private Integer length;
    @SerializedName("luhn")
    private Boolean luhn;

    public NumberDto(Integer length, Boolean luhn) {
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
