package com.kotlin.playground.startpack.collections

//High order function
fun calculate(x: Int, y: Int,op: (x: Int, y: Int) -> Int): Int {
    return op(x, y)
}

fun main() {
    val addLamda = { x:Int -> x+x}
    val addResult = addLamda(3)
    println("addresult$addResult")
    val multiplyLamda = {x: Int, y: Int ->
        println("x $x, y $y")
        x*y // Always the result will be the last line
    }
    println("multiplyLamda: $multiplyLamda")

    println("High order multiple: ${calculate(2,3, multiplyLamda)}")
    val add = calculate(2, 3) { a: Int, b: Int -> a + b }
    println("High order add: $add")
//we can pass the behaviour as a param
}