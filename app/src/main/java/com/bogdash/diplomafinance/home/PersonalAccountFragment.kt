package com.bogdash.diplomafinance.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.databinding.FragmentPersonalAccountBinding
import com.bogdash.diplomafinance.market.MarketAdapter
import com.bogdash.diplomafinance.market.Stock
import com.bogdash.diplomafinance.market.StocksService

class PersonalAccountFragment : Fragment() {
    private lateinit var binding: FragmentPersonalAccountBinding
    private lateinit var adapter: StocksAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var portfolioStocksArrayList: ArrayList<PortfolioStock>
    private lateinit var portfolioStockService: PortfolioStockService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalAccountBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view_portfolio_stock)
        recyclerView.layoutManager = layoutManager
        adapter = StocksAdapter(portfolioStocksArrayList, requireContext())
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        portfolioStockService = PortfolioStockService(requireContext())
        portfolioStocksArrayList = portfolioStockService.getStocks()
    }
}