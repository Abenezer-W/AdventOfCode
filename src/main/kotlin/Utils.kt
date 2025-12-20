package com.example

import java.io.File


fun readFileToString(filePath: String) : String{
    return File(filePath).readText()
}

fun repeatWord(word: String, times: Int) : String{
    val sb = StringBuilder(word.length*times)
    repeat(times){sb.append(word)}
    return sb.toString()
}

