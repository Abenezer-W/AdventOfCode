package com.example.Day4


import com.example.readFileToString
import java.util.LinkedList
import java.util.Queue


fun main() {
    val input = readFileToString("src/main/kotlin/Day4/Day4Input.txt").split("\n").map { it.toMutableList() }
    var res = 0
    val que: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 0..<input.size) {
        for (j in 0..<input[0].size) {
            if (input[i][j] == '@') {
                if (canBeRemoved(input, i to j)) {
                    que.add(i to j)
                }
            }
        }
    }
    val visited = mutableSetOf<Pair<Int, Int>>()
    while (!que.isEmpty()) {
        val currIdx = que.poll()
        if (currIdx !in visited) {
            visited.add(currIdx)
            res++
            input[currIdx.first][currIdx.second] = '.'
            val validRolls = findValidNeighbors(input, currIdx)
            que.addAll(validRolls)
        }
    }
    println(res)
}

fun findValidNeighbors(input: List<List<Char>>, idx: Pair<Int, Int>): List<Pair<Int, Int>> {
    val validPaperRolls = mutableListOf<Pair<Int, Int>>()
    val directions = listOf(
        0 to 1, 0 to -1,
        1 to 0, 1 to 1, 1 to -1,
        -1 to 0, -1 to 1, -1 to -1
    )
    for (d in directions) {
        val newy = idx.first + d.first
        val newx = idx.second + d.second
        if (newx in 0..<input[0].size && newy in 0..<input.size && canBeRemoved(
                input,
                newy to newx
            ) && input[newy][newx] != '.'
        ) {
            validPaperRolls.add(newy to newx)
        }
    }
    return validPaperRolls
}


fun canBeRemoved(input: List<List<Char>>, idx: Pair<Int, Int>): Boolean {
    val directions = listOf(
        0 to 1, 0 to -1,
        1 to 0, 1 to 1, 1 to -1,
        -1 to 0, -1 to 1, -1 to -1
    )
    var count = 0

    for (d in directions) {
        val newy = idx.first + d.first
        val newx = idx.second + d.second
        if (newx in 0..<input[0].size && newy in 0..<input.size) {
            if (input[newy][newx] == '@') {
                count++
                if (count >= 4) {
                    return false
                }
            }
        }
    }
    return true
}






