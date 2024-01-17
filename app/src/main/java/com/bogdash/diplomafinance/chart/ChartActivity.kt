package com.bogdash.diplomafinance.chart

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowInsetsController
import android.widget.Switch
import android.widget.TextView
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.databinding.ActivityChartBinding
import com.bogdash.diplomafinance.movingaverages.simpleMovingAverage
import com.bogdash.diplomafinance.movingaverages.weightedMovingAverages
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate

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

        switchSMA = binding.switchSma
        switchWMA = binding.switchWma
        lineChart = binding.lineChart

        chart()
        switchSMA.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchWMA.isChecked = false
                updateChart()
            } else {
                updateChart()
            }
        }

        switchWMA.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchSMA.isChecked = false
                updateChart()
            } else {
                updateChart()
            }
        }
    }

    private fun updateChart() {
        if (!switchSMA.isChecked && !switchWMA.isChecked) {
            chart()
        } else if (switchSMA.isChecked) {
            chartSMA()
        } else if (switchWMA.isChecked) {
            chartWMA()
        }
    }

    private fun chart() {

        val list: Array<Float> = arrayOf(5f, 3f, 4f, 2f, 1f, 6f, 7f, 8f, 8f, 5f)
        val listEntry = arrayToEntry(list)
        val lineDataSet1 = LineDataSet(listEntry, "List")
        lineDataSet1.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        lineDataSet1.valueTextColor = Color.BLACK

        val lineData = LineData(lineDataSet1)
        lineChart.data = lineData
        lineChart.description.text = "Line chart"

        lineChart.animateY(300)
    }

    private fun chartSMA() {
        val list: Array<Float> = arrayOf(5f, 3f, 4f, 2f, 1f, 6f, 7f, 8f, 8f, 5f)
        val listEntry = arrayToEntry(list)

        // сглаженные данные
        val window = 3
        val movingList = simpleMovingAverage(list, window)
        val movingListEntry = arrayToEntry(movingList)

        // отображение линий
        val lineDataSet1 = LineDataSet(listEntry, "List")
        lineDataSet1.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        lineDataSet1.valueTextColor = Color.BLACK

        val lineDataSet2 = LineDataSet(movingListEntry, "Moving List")
        lineDataSet2.setColors(ColorTemplate.JOYFUL_COLORS, 255)
        lineDataSet2.valueTextColor = Color.BLACK
        lineDataSet2.mode = LineDataSet.Mode.CUBIC_BEZIER

        val lineData = LineData(lineDataSet1, lineDataSet2)

        lineChart.data = lineData
        lineChart.description.text = "Line chart"

        lineChart.animateY(300)
    }

    private fun chartWMA() {
        val list: Array<Float> = arrayOf(5f, 3f, 4f, 2f, 1f, 6f, 7f, 8f, 8f, 5f)
        val listEntry = arrayToEntry(list)

        // сглаженные данные
        val window = 3
        val weights: List<Double> = listOf(0.3, 0.5, 0.2)
        val movingList = weightedMovingAverages(list, window, weights)
        val movingListEntry = arrayToEntry(movingList)

        // отображение линий
        val lineDataSet1 = LineDataSet(listEntry, "List")
        lineDataSet1.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        lineDataSet1.valueTextColor = Color.BLACK

        val lineDataSet2 = LineDataSet(movingListEntry, "Moving List")
        lineDataSet2.setColors(ColorTemplate.JOYFUL_COLORS, 255)
        lineDataSet2.valueTextColor = Color.BLACK
        lineDataSet2.mode = LineDataSet.Mode.CUBIC_BEZIER

        val lineData = LineData(lineDataSet1, lineDataSet2)

        lineChart.data = lineData
        lineChart.description.text = "Line chart"

        lineChart.animateY(300)
    }
    private fun arrayToEntry(array: Array<Float>): MutableList<Entry> {
        val result = array.mapIndexed{ index, average ->
        Entry(index.toFloat(), average)}.toMutableList()
        return result
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