package com.example.test.data.model

import com.google.gson.annotations.SerializedName

class CountryDto (
    @SerializedName("numeric") val numeric: Int,
    @SerializedName("alpha2") val alpha2: String,
    @SerializedName("name") val name: String,
    @SerializedName("emoji") val emoji: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("latitude") val latitude: Float,
    @SerializedName("longitude") val longitude: Float
    ) {
    override fun toString(): String {
        return "CountryDtoK(numeric=$numeric, alpha2='$alpha2', name='$name', emoji='$emoji', currency='$currency', latitude=$latitude, longitude=$longitude)"
    }
}