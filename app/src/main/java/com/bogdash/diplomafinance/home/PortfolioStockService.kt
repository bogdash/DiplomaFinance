package com.bogdash.diplomafinance.home

import android.content.Context
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.market.Stock

class PortfolioStockService(private val _context: Context) {
    private val context: Context = _context

    fun getStocks(): ArrayList<PortfolioStock> {
        val portfolioStocksArrayList = arrayListOf<PortfolioStock>()

        val pictureId = arrayOf(
            R.drawable.sberbank,
            R.drawable.gazprom_icon,
            R.drawable.luk_oil_logo_2,
            R.drawable.rosneft_logo
        )

        val titleId = arrayOf(
            R.string.title_1,
            R.string.title_2,
            R.string.title_3,
            R.string.title_4
        )

        val titles = titleId.map { context.getString(it) }

        val countId = arrayOf(
            R.string.count_1,
            R.string.count_2,
            R.string.count_3,
            R.string.count_4,
        )

        val count = countId.map { context.getString(it) }

        val sumId = arrayOf(
            R.string.sum_1,
            R.string.sum_2,
            R.string.sum_3,
            R.string.sum_4,
        )

        val sum = sumId.map { context.getString(it) }

        val diffId = arrayOf(
            R.string.diff_1,
            R.string.diff_2,
            R.string.diff_3,
            R.string.diff_4,
        )

        val diff = diffId.map { context.getString(it) }

        for (i in pictureId.indices) {
            val portfolioStocks = PortfolioStock(pictureId[i], titles[i], count[i], sum[i], diff[i])
            portfolioStocksArrayList.add(portfolioStocks)
        }

        return portfolioStocksArrayList
    }
}