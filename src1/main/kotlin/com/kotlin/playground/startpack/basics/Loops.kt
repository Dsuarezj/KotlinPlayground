package com.kotlin.playground.startpack.basics

fun main(){
    val something = "some variable text"
    val range = 1..something.length
    println(range)

    for (i in range){
        println("i: $i")
    }

    for(i in 0 .. 9){
        println("range 0 .. 9  count: $i")
        i
    }

    for (i in 0 until 10) {
        println ("until 10 count: $i")
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

    exploreWhile()
    exploreDoWhile()
}

fun exploreDoWhile() {
    var x = 1
    do {
        println("do  while x < 5: $x" )
        x++
    } while (x < 5)
}

fun exploreWhile() {
    var x = 1
    while (x <5){
        println("while x < 5: $x" )
        x++
    }
}
