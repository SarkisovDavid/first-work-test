package com.example.test.data.api

import com.example.test.data.model.CardDto
import com.example.test.data.model.NumberDto
import com.example.test.domain.model.BankInfoItemModel
import com.example.test.domain.model.CardInfoItemModel
import com.example.test.domain.model.CountryInfoItemModel
import com.example.test.domain.model.MainCardInfo
import javax.inject.Inject

class MainConverter @Inject constructor() {

    fun convert(card: CardDto): List<CardInfoItemModel> {
        val listCardInfo: MutableList<CardInfoItemModel> = mutableListOf()
        if (infoRealValue(card.scheme)) {
            val mainCardInfoScheme: MainCardInfo = MainCardInfo("Scheme:", card.scheme)
            listCardInfo.add(mainCardInfoScheme)
        }
        if (infoRealValue(card.type)) {
            val mainCardInfoType: MainCardInfo = MainCardInfo("Type:", card.type)
            listCardInfo.add(mainCardInfoType)
        }
        if (infoRealValue(card.brand)) {
            val mainCardInfoBrand: MainCardInfo = MainCardInfo("Brand:", card.brand)
            listCardInfo.add(mainCardInfoBrand)
        }
        val mainCardInfoPrepaid: MainCardInfo = MainCardInfo("Prepaid:", booleanToString(card.isPrepaid, "Yes", "No"))
        listCardInfo.add(mainCardInfoPrepaid)
        if (infoRealValue(card.country.currency)) {
            val mainCardInfoBrand: MainCardInfo = MainCardInfo("Currency:", card.country.currency)
            listCardInfo.add(mainCardInfoBrand)
        }
        if (numberInfo(card.number) != null) {
            val mainCardInfoNumber: MainCardInfo = MainCardInfo("Number:", numberInfo(card.number))
            listCardInfo.add(mainCardInfoNumber)
        }
        val countryInfoItemModel: CountryInfoItemModel = CountryInfoItemModel(
            "Country name:",
            "Coordinate:",
            "${card.country.alpha2} ${card.country.name}",
            "${card.country.latitude}/${card.country.longitude}")
        listCardInfo.add(countryInfoItemModel)
        if (card.bank.name != null || card.bank.url != null || card.bank.phone != null) {
            val bankInfoItemModel: BankInfoItemModel = BankInfoItemModel(
                "Bank info:",
                card.bank.name,
                card.bank.url,
                card.bank.phone
            )
            listCardInfo.add(bankInfoItemModel)
        }
        return listCardInfo
    }

    private fun numberInfo(number: NumberDto): String? {
        var numberCardInfo: String? = null
        if (number.length != null && number.isLuhn != null) {
            numberCardInfo = "Length: " + number.length + "\n" + "Luhn: " + booleanToString(number.isLuhn, "Yes", "No")
        } else if (number.length != null) {
            numberCardInfo = "Length: " + number.length;
        } else if (number.isLuhn != null) {
            numberCardInfo = "Luhn: " + booleanToString(number.isLuhn, "Yes", "No")
        }
        return numberCardInfo;
    }

    private fun booleanToString(predicate: Boolean, trueString: String, falseString: String): String {
        val result: String = if (predicate) {
            trueString
        } else {
            falseString
        }
        return result
    }

    private fun infoRealValue(info: String): Boolean {
        var infoIsNotEmpty: Boolean = false
        if (info.isNotEmpty()) {
            infoIsNotEmpty = true
        }
        return infoIsNotEmpty
    }
}