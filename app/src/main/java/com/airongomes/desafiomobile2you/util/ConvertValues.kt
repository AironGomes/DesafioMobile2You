package com.airongomes.desafiomobile2you.util

import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Function used to abbreviate the number of likes
 */
fun abbreviateValue(number: Double): String {
    return if(number < 1000.0) {
        val df = DecimalFormat("#").apply {
            roundingMode = RoundingMode.DOWN
        }
        df.format(number)
    }
    else {

        val df = DecimalFormat("#.#").apply {
            roundingMode = RoundingMode.DOWN
        }
        when (number) {
            in 1001.0..999999.0 -> "${df.format(number/1000.0)}k"
            in 1000000.0..999999999.0 -> "${df.format(number/1000000.0)}M"
            else -> "${df.format(number/1000000000.0)}B"
        }
    }
}