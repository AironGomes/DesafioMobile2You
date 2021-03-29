package com.airongomes.desafiomobile2you.util

import org.junit.Assert.*
import org.junit.Test

class MapGenreTest {

    @Test
    fun getGenreName_emptyList_returnEmptyString() {
        // Create variables with empty List
        val list = listOf<Int>()
        val result = getGenreName(list)
        assertEquals(result, "")
    }

    @Test
    fun getGenreName_listWithOneValue_returnStringWithOneGenre() {
        // Create variables with empty List
        val list = listOf(18)
        val result = getGenreName(list)
        assertEquals(result, "Drama")
    }

    @Test
    fun getGenreName_listWithMultipleValues_returnStringWithFirstTwoGenres() {
        // Create variables with multiple values
        val list = listOf(80, 27)
        val list2 = listOf(10752, 99, 36)
        val list3 = listOf(35, 36, 16, 10402, 10749)

        val result = getGenreName(list)
        val result2 = getGenreName(list2)
        val result3 = getGenreName(list3)

        assertEquals(result, "Crime, Horror")
        assertEquals(result2, "War, Documentary")
        assertEquals(result3, "Comedy, History")
    }

    @Test
    fun getGenreName_listWithIncorrectValues_stringWithFirstTwoGenresIfCorrespondsId() {
        // Create variables with multiple values
        val list = listOf(59)
        val list2 = listOf(99, 21)
        val list3 = listOf(39, 68, 16, 11, 10749)

        val result = getGenreName(list)
        val result2 = getGenreName(list2)
        val result3 = getGenreName(list3)

        assertEquals(result, "")
        assertEquals(result2, "Documentary")
        assertEquals(result3, "Animation, Romance")
    }
}