package com.kotlin.playground.basics

fun main() {

    label()
    for (i in 1..5) {
        println("i in $i")
        //if (i == 3) break
        if (i == 3) return
    }

    println("with break it will reach this point, with return no")
}

fun label() {
    loop@ for (i in 1..5) {
        println("i in label $i")
        innerloop@ for (j in 1..5) {
            println("j in label $j")
            if (j == 2) continue@loop
        }
    }
}
