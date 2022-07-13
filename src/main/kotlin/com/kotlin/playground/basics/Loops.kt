package com.kotlin.playground.basics

fun main(){
    val something = "some variable text"
    val range = 1..something.length
    println(range)

    for (i in range){
        println("i: $i")
    }
    val reverseRange = 10 downTo 1
    println(reverseRange)

    for (i in reverseRange){
        println("i reverse: $i")
    }

    val reverseRangeWithSkip = 10 downTo 1 step 2
    println(reverseRangeWithSkip)

    for (i in reverseRangeWithSkip){
        println("i reverse: $i")
    }
}