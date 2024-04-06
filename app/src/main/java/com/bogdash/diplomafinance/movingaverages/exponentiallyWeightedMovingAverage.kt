package com.bogdash.diplomafinance.movingaverages

fun exponentiallyWeightedMovingAverage(array: Array<Float>, alpha: Float): Array<Float> {

    val result = mutableListOf<Float>()
    var ema = array[0]

    for (i in array.indices) {
        ema = alpha * array[i] + (1 - alpha) * ema
        result.add(ema)
    }
    return result.toTypedArray()
}