package com.example.test.data.model

import com.google.gson.annotations.SerializedName

class CardDto (
    @SerializedName("scheme") val scheme: String,
    @SerializedName("type") val type: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("prepaid") val prepaid: Boolean,
    @SerializedName("bank") val bank: BankDto,
    @SerializedName("country") val country: CountryDto,
    @SerializedName("number") val number: NumberDto
    ) {
    override fun toString(): String {
        return "CardDto(scheme='$scheme', type='$type', brand='$brand', prepaid=$prepaid, bank=$bank, country=$country, number=$number)"
    }
}