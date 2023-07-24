package com.example.test.data.model

import com.google.gson.annotations.SerializedName

class NumberDto (
    @SerializedName("length") val length: Integer,
    @SerializedName("luhn") val luhn: Boolean
    ) {
    override fun toString(): String {
        return "NumberDtoK(length=$length, luhn=$luhn)"
    }
}