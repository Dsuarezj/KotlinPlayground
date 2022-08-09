package com.kotlin.playground.basics

fun main() {
    val name = "memise"
    println("hello $name, the length of the name is ${name.length}")
    val multiline = """
        A
        #b
        C
        #d
    """.trimMargin("#")
    println(multiline)

    val length = if (name.length == 4) {
        println("name length is 4")
        name.length
    } else {
        println("name length is not 4")
        name.length
    }
    println(length)

    val position = 2

    val medal = when (position) {
        1 -> "Gold"
        2 -> "Silver"
        3 -> "Bronze"
        else -> "no medal"
    }


    println(medal)

    //As a general rule, use when if you have more than two conditions. Use if for simple cases.


    // data types inmutable

    val hobbits = listOf("Frodo", "Sam", "Pippin", "Merry", "Merry")
    println("hobbits $hobbits")
    println("hay un total de  ${hobbits.size}")
    println("lista to array  ${hobbits.toTypedArray()}")
    println(hobbits[4])
    val countries = setOf("Catalonia", "Taiwan", "Gran Colombia") //  Looking for the presence of an element in a set is much faster than looking it up in a list. But, unlike lists, sets don't provide indexes access. FIFO
    println("countries $countries")
    println("Taiwan" in countries)
    println("China" in countries)

    val movies = mapOf("peli1" to "director1", "peli2"  to "director 2")
    println("Peli que existe: ${"peli1" in movies}")
    println("Peli que existe: ${movies["peli1"]}")
    println("Peli que no existe: ${"peli4" !in movies}")
    println("Peli que no existe: ${movies["peli4"]}")

    // mutable
    val colores = mutableListOf("red", "green", "blue")
    println("colores primarios $colores")
    colores.add(2, "yellow")
    println("añadimos mas colores $colores")
}