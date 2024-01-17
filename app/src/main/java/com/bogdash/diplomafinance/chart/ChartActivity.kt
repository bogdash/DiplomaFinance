package com.bogdash.diplomafinance.chart

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.WindowInsetsController
import android.widget.Switch
import android.widget.TextView
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.databinding.ActivityChartBinding
import com.bogdash.diplomafinance.movingaverages.simpleMovingAverage
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.materialswitch.MaterialSwitch

class ChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChartBinding
    private lateinit var lineChart: LineChart

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var switchSMA: Switch
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var switchWMA: Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        }

        val title = intent.getStringExtra("title")
        val textViewStock: TextView = binding.tvStockTopAppBar
        textViewStock.text = title

        val price = intent.getStringExtra("price")
        val textViewPrice: TextView = binding.tvPriceChartActivity
        textViewPrice.text = price

        val toolbar = binding.topAppBar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        chartDrawing()

        switchSMA = binding.switchSma
        switchWMA = binding.switchWma

        switchSMA.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchWMA.isChecked = false
            }
        }

        switchWMA.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchSMA.isChecked = false
            }
        }

    }

    private fun chartDrawing() {
        // исходный график
        lineChart = binding.lineChart
        val list: ArrayList<Entry> = ArrayList()

        list.add(Entry(1f, 5f))
        list.add(Entry(2f, 3f))
        list.add(Entry(3f, 4f))
        list.add(Entry(4f, 2f))
        list.add(Entry(5f, 1f))
        list.add(Entry(6f, 6f))
        list.add(Entry(7f, 7f))
        list.add(Entry(8f, 8f))
        list.add(Entry(9f, 8f))
        list.add(Entry(10f, 5f))

        // сглаженные данные
        val movingList: ArrayList<Entry> = ArrayList()

        movingList.add(Entry(3f, 4f))
        movingList.add(Entry(4f, 3f))
        movingList.add(Entry(5f, 2.33f))
        movingList.add(Entry(6f, 3f))
        movingList.add(Entry(7f, 4.66f))
        movingList.add(Entry(8f, 7f))
        movingList.add(Entry(9f,7.66f))
        movingList.add(Entry(10f, 7f))

        // отображение линий
        val lineDataSet1 = LineDataSet(list, "List")
        lineDataSet1.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        lineDataSet1.valueTextColor = Color.BLACK

        val lineDataSet2 = LineDataSet(movingList, "Moving List")
        lineDataSet2.setColors(ColorTemplate.JOYFUL_COLORS, 255)
        lineDataSet2.valueTextColor = Color.BLACK
        lineDataSet2.mode = LineDataSet.Mode.CUBIC_BEZIER

        val lineData = LineData(lineDataSet1, lineDataSet2)

        lineChart.data = lineData
        lineChart.description.text = "Line chart"

        lineChart.animateY(300)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_for_tool_bar, menu)
        return true
    }
}