package com.example.test.data.database

import com.example.test.data.model.CardDto
import com.example.test.data.model.CardEntity
import javax.inject.Inject

class CardEntityConverter @Inject constructor(private var filterCard: FilterCard) {

    fun convertForHistory(card: CardDto, userBin: String, timestamp: String): CardEntity {
        return CardEntity(userBin, card.scheme, card.type, card.bank.name, timestamp)
    }

    fun convert(cardEntity: List<CardEntity>): Map<String, String> {
        val fromHistory = LinkedHashMap<String, String>()
        for (entity in cardEntity) {
            fromHistory[entity.bin] = bankName(entity.scheme) + bankName(entity.type) +
                bankName(entity.bankName) + entity.timestamp
        }
        return filterCard.filterMap(fromHistory);
    }

    private fun bankName(string: String?): String {
        return if (!string.isNullOrEmpty()) {
            "$string, "
        } else {
            ""
        }
    }
}