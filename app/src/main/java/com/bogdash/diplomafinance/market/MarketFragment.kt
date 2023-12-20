package com.bogdash.diplomafinance.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.diplomafinance.R

class MarketFragment : Fragment() {

    private lateinit var adapter: MarketAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var stocksArrayList: ArrayList<Stock>

    lateinit var pictureId: Array<Int>
    lateinit var title: Array<String>
    lateinit var ticker: Array<String>
    lateinit var price: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_market, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MarketAdapter(stocksArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        stocksArrayList = arrayListOf()

        pictureId = arrayOf(
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

        title = arrayOf(
            getString(R.string.title_1),
            getString(R.string.title_2),
            getString(R.string.title_3),
            getString(R.string.title_4),
            getString(R.string.title_5),
            getString(R.string.title_6),
            getString(R.string.title_7),
            getString(R.string.title_8),
            getString(R.string.title_9),
            getString(R.string.title_10)
        )

        ticker = arrayOf(
            getString(R.string.ticker_1),
            getString(R.string.ticker_2),
            getString(R.string.ticker_3),
            getString(R.string.ticker_4),
            getString(R.string.ticker_5),
            getString(R.string.ticker_6),
            getString(R.string.ticker_7),
            getString(R.string.ticker_8),
            getString(R.string.ticker_9),
            getString(R.string.ticker_10)
        )

        price = arrayOf(
            getString(R.string.price_1),
            getString(R.string.price_2),
            getString(R.string.price_3),
            getString(R.string.price_4),
            getString(R.string.price_5),
            getString(R.string.price_6),
            getString(R.string.price_7),
            getString(R.string.price_8),
            getString(R.string.price_9),
            getString(R.string.price_10)
        )

        for (i in pictureId.indices) {
            val stocks = Stock(pictureId[i], title[i], ticker[i], price[i])
            stocksArrayList.add(stocks)
        }
    }
}