package com.bogdash.diplomafinance.movingaverages

fun simpleMovingAverage (array: Array<Int>, window: Int): Array<Float> {
    require(window > 0) { "Размер окна должен быть положительным числом" }

    val result = mutableListOf<Float>()

    for (i in window - 1..<array.size) {
        val windowValues = array.copyOfRange(i - window + 1, i + 1)
        val average = windowValues.average().toFloat()
        result.add(average)
    }

    return result.toTypedArray()
}