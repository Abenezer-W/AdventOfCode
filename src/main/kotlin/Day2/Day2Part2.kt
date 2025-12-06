package com.example.Day2

import com.example.readFileToString
import com.example.repeatWord


fun main(){
    val inputText = readFileToString("src/main/kotlin/Day2.txt")
    val ranges = inputText.split(",").map { it.lines().joinToString("").split("-") }
    var resIdSum = 0L
    println()
    for (range in ranges){
        val start = range[0].toLong()
        val end = range[1].toLong()
        for(i in start..end){

            var currNumStr = i.toString()
            for(j in 1..currNumStr.length/2){
                val currSubString = currNumStr.take(j)
                val q = currNumStr.length/currSubString.length
                val r = currNumStr.length%currSubString.length

                if(r == 0 && repeatWord(currSubString, q) == currNumStr){
                    println("$i")
                    resIdSum+=i
                    break
                }
            }
        }
    }
    println(resIdSum)
}
