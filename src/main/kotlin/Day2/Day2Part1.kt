package com.example.Day2

import com.example.readFileToString

fun main() {
    val inputText = readFileToString("src/main/kotlin/Day2.txt")
    val ranges = inputText.split(",").map { it.lines().joinToString("").split("-") }
    println(ranges)
    var resIdSum = 0L

    for (range in ranges) {
        val start = range[0].toLong()
        val end = range[1].toLong()
        for (i in start..end) {
            val currNumStr = i.toString()
            if (currNumStr.length % 2 == 0) {
                val left = currNumStr.substring(0, currNumStr.length / 2)
                val right = currNumStr.substring(currNumStr.length / 2)
                if (left == right) {
                    println(i)
                    resIdSum += i
                }
            }
        }
    }
    println(resIdSum)
}
