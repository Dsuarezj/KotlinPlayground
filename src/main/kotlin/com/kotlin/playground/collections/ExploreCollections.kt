package com.kotlin.playground.collections

fun main() {
    val names = listOf("Alice", "Bob", "Eve") // Immutable list, not have the .add function
    println("Names: $names")
    val mutableNames = mutableListOf("Alice")
    println("mutable names begin: $mutableNames")
    mutableNames.add("Bob")
    println("mutable names begin: $mutableNames")

    val setNames = setOf("Alice", "Bob", "Eve")
    println(setNames)

    val nameAgeMap = mapOf("Dilip" to 34, "Alex" to 23)
    println(nameAgeMap)
    val nameAgeMapMutable = mutableMapOf("Dilip" to 34, "Alex" to 23)
    println(nameAgeMapMutable)
    nameAgeMapMutable["Bob"] = 32
    println(nameAgeMapMutable)

}