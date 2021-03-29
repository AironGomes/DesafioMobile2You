package com.airongomes.desafiomobile2you.util

import org.junit.Assert.*
import org.junit.Test

class ConvertValuesTest {

    @Test
    fun abbreviateValue_lessThanThousand_returnNoAbbreviated() {
        // Create variables with less than a thousand likes
        val value = 600.00
        val value2 = 0.00
        val value3 = -1000.00

        val result = abbreviateValue(value)
        val result2 = abbreviateValue(value2)
        val result3 = abbreviateValue(value3)

        assertEquals(result, "600")
        assertEquals(result2, "0")
        assertEquals(result3, "-1000")
    }

    @Test
    fun abbreviateValue_greaterThanThousand_returnAbbreviatedWithK() {
        // Create variables with more than a thousand likes
        val value = 1020.0
        val value2 = 1200.0
        val value3 = 1630.0
        val value4 = 930000.0

        val result = abbreviateValue(value)
        val result2 = abbreviateValue(value2)
        val result3 = abbreviateValue(value3)
        val result4 = abbreviateValue(value4)

        assertEquals(result, "1k")
        assertEquals(result2, "1.2k")
        assertEquals(result3, "1.6k")
        assertEquals(result4, "930k")
    }

    @Test
    fun abbreviateValue_greaterThanMillion_returnAbbreviatedWithM() {
        // Create variables with more than a million likes
        val value = 1000000.0
        val value2 = 1200000.0
        val value3 = 8000200.0

        val result = abbreviateValue(value)
        val result2 = abbreviateValue(value2)
        val result3 = abbreviateValue(value3)

        assertEquals(result, "1M")
        assertEquals(result2, "1.2M")
        assertEquals(result3, "8M")
    }

    @Test
    fun abbreviateValue_greaterThanBillion_returnAbbreviatedWithB() {
        // Create variables with more than a billion likes
        val value = 1000000000.0
        val value2 = 1200000000.0
        val value3 = 8090000000.0

        val result = abbreviateValue(value)
        val result2 = abbreviateValue(value2)
        val result3 = abbreviateValue(value3)

        assertEquals(result, "1B")
        assertEquals(result2, "1.2B")
        assertEquals(result3, "8B")
    }

}