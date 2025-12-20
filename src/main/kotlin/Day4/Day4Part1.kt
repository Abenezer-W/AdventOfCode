package com.example.Day4

import com.example.readFileToString



fun main() {
    val input = readFileToString("src/main/kotlin/Day4/Day4Input.txt").split("\n").map { it.toList() }
    var res = 0
    for (i in 0..<input.size) {
        for (j in 0..<input[0].size) {
            if (input[i][j] == '@') {
               if(canBeRemoved(input, i to j)){
                   res++
               }
            }
        }
    }
    println(res)
}



