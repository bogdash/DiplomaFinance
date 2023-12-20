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
    private lateinit var stocksService: StocksService

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
        adapter = MarketAdapter(stocksArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        stocksService = StocksService(requireContext())
        stocksArrayList = stocksService.getStocks()
    }
}