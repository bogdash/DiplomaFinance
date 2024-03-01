package com.bogdash.diplomafinance.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.chart.ChartActivity
import com.bogdash.diplomafinance.market.MarketAdapter

class StocksAdapter(private val portfolioStocksList: ArrayList<PortfolioStock>, private val context: Context) : RecyclerView.Adapter<StocksAdapter.StocksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_stocks, parent, false)
        return StocksAdapter.StocksViewHolder(itemView)
    }

    override fun getItemCount() = portfolioStocksList.size

    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        val currentItem = portfolioStocksList[position]
        holder.picture.setImageResource(currentItem.picture)
        holder.title.text = currentItem.title
        holder.count.text = currentItem.count
        holder.sum.text = currentItem.sum
        holder.priceDiff.text = currentItem.diff
    }

    class StocksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val picture: ImageView = itemView.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.text_view_name_stocks)
        val count: TextView = itemView.findViewById(R.id.text_view_count_stocks)
        val sum: TextView = itemView.findViewById(R.id.text_view_summ)
        val priceDiff: TextView = itemView.findViewById(R.id.text_view_diff)
    }
}