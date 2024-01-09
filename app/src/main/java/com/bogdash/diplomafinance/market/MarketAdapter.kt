package com.bogdash.diplomafinance.market

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.chart.ChartActivity

class MarketAdapter(private val stocksList: ArrayList<Stock>, private val context: Context) : RecyclerView.Adapter<MarketAdapter.MarketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_market, parent, false)
        return MarketViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return stocksList.size
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        val currentItem = stocksList[position]
        holder.picture.setImageResource(currentItem.picture)
        holder.title.text = currentItem.title
        holder.ticker.text = currentItem.ticker
        holder.price.text = currentItem.price
        holder.itemMarket.setOnClickListener {
            val intent = Intent(context, ChartActivity::class.java)
            context.startActivity(intent)
        }
    }

    class MarketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val picture: ImageView = itemView.findViewById(R.id.stock_picture)
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val ticker: TextView = itemView.findViewById(R.id.tv_ticker)
        val price: TextView = itemView.findViewById(R.id.tv_price)
        val itemMarket: ConstraintLayout = itemView.findViewById(R.id.item_market)
    }

}