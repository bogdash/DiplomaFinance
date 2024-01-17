package com.bogdash.diplomafinance.movingaverages

fun weightedMovingAverages(array: Array<Float>, window: Int, weights: List<Double>): Array<Float> {
    require(window > 0 && weights.size == window)
    { "Размер окна должен быть положительным числом, и размер весов должен соответствовать размеру окна" }

    val result = mutableListOf<Float>()

    for (i in window - 1 until array.size) {
        val windowValues = array.copyOfRange(i - window + 1, i + 1)
        val weightedAverage = calculateWeightedAverage(windowValues, weights)
        result.add(weightedAverage)
    }

    return result.toTypedArray()
}

fun calculateWeightedAverage(values: Array<Float>, weights: List<Double>): Float {
    require(values.size == weights.size)
    { "Размер значений должен соответствовать размеру весов" }

    var weightedSum = 0.0
    var weightSum = 0.0

    for (j in values.indices) {
        weightedSum += values[j] * weights[j]
        weightSum += weights[j]
    }

    return (weightedSum / weightSum).toFloat()
}