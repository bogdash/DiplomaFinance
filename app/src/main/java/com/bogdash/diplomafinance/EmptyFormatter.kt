package com.bogdash.diplomafinance

import com.github.mikephil.charting.formatter.ValueFormatter

class EmptyFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return ""
    }
}