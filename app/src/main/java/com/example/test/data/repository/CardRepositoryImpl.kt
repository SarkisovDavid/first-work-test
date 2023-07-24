package com.example.test.data.repository

import com.example.test.data.api.ApiService
import com.example.test.data.api.MainConverter
import com.example.test.data.database.BinDao
import com.example.test.data.database.CardEntityConverter
import com.example.test.domain.model.CardInfoItemModel
import com.example.test.domain.repository.CardRepository
import io.reactivex.rxjava3.core.Single
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val mainConverter: MainConverter,
    private val apiService: ApiService,
    private val binDao: BinDao,
    private val cardEntityConverter: CardEntityConverter
): CardRepository {

    override fun getCardInfo(bin: String): Single<List<CardInfoItemModel>> {
        return apiService.cardInfo(bin)
            .doOnSuccess { card ->
                val date = Date()
                val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                val history = cardEntityConverter.convertForHistory(card, bin, format.format(date));
                binDao.insertBin(history);
            }
            .map { cardDto ->
                mainConverter.convert(cardDto)
            }
    }

        override fun getHistoryCard(): Single<List<Map.Entry<String, String>>>  {
        return binDao.getHistoryCardBin()
            .map {  cardEntities -> ArrayList(cardEntityConverter.convert(cardEntities).entries)
            }
    }
}