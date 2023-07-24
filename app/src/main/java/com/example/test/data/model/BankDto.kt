package com.example.test.data.model

import com.google.gson.annotations.SerializedName

class BankDto (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("city") val city: String
    )
{

    override fun toString(): String {
        return "BankDto(name='$name', url='$url', phone='$phone', city='$city')"
    }
}