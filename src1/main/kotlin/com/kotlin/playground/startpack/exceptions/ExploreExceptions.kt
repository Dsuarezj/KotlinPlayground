package com.kotlin.playground.startpack.exceptions

fun main() {
    println("Name length is ${nameLength("Alicce")}")
    println("Name length is ${nameLength(null)}")
    returnNothing()

}

fun nameLength(name: String?): Int? {
    return try {
         name!!.length
     } catch (ex: Exception) {
         println("Exception is: $ex")
         null
     }
}

fun returnNothing(): Nothing {
    throw RuntimeException("usless")
}
