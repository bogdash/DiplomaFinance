package com.bogdash.diplomafinance.market

import android.content.Context
import com.bogdash.diplomafinance.R

class StocksService(private val _context: Context) {

    private val context: Context = _context

    fun getStocks(): ArrayList<Stock> {
        val stocksArrayList = arrayListOf<Stock>()

        val pictureId = arrayOf(
            R.drawable.sberbank,
            R.drawable.gazprom_icon,
            R.drawable.luk_oil_logo_2,
            R.drawable.rosneft_logo,
            R.drawable.yandex_znak,
            R.drawable.tcs_3,
            R.drawable.flowers_inc,
            R.drawable.genomics,
            R.drawable.tsvt,
            R.drawable.twou
        )

        val titleId = arrayOf(
            R.string.title_1,
            R.string.title_2,
            R.string.title_3,
            R.string.title_4,
            R.string.title_5,
            R.string.title_6,
            R.string.title_7,
            R.string.title_8,
            R.string.title_9,
            R.string.title_10
        )

        val titles = titleId.map { context.getString(it) }

        val tickerId = arrayOf(
            R.string.ticker_1,
            R.string.ticker_2,
            R.string.ticker_3,
            R.string.ticker_4,
            R.string.ticker_5,
            R.string.ticker_6,
            R.string.ticker_7,
            R.string.ticker_8,
            R.string.ticker_9,
            R.string.ticker_10
        )

        val tickers = tickerId.map { context.getString(it) }

        val priceId = arrayOf(
            R.string.price_1,
            R.string.price_2,
            R.string.price_3,
            R.string.price_4,
            R.string.price_5,
            R.string.price_6,
            R.string.price_7,
            R.string.price_8,
            R.string.price_9,
            R.string.price_10
        )

        val prices = priceId.map { context.getString(it) }

        for (i in pictureId.indices) {
            val stocks = Stock(pictureId[i], titles[i], tickers[i], prices[i])
            stocksArrayList.add(stocks)
        }

        return stocksArrayList
    }
}