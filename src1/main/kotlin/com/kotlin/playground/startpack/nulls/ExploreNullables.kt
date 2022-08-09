package com.kotlin.playground.startpack.nulls
data class Movie(
    val id: Int?, val name: String
)

fun printName(name: String) {
    println("Name is $name")
}

fun main() {
    var nameNullables: String? = null

    // println(printName(nameNullables!!)) this will generate a null pointeer
    nameNullables?.run {
        printName(this)
    }
    println("value is: $nameNullables")
    println("value is: ${nameNullables?.length}") // ? safe operator
    var length = nameNullables?.length
    println("length: ${length?.toLong()}") // null
    length = nameNullables?.length ?: 0 // ?:  elvis operator
    println("length: $length") // 0
    nameNullables = "Algo ya no nulo"
    nameNullables?.run {
        printName(this)
    }
    length = nameNullables.length // we don't need the safe operator in here due
    println("length: $length") // 4



    // val name: String = null -> this won't work

    val name: String = "Bernabe"
    val movie = Movie(null, "movie 1")
    val savedMovie = saveMovie(movie)
    println(savedMovie.id!!) // !! will make sure that this value is never null and will throw a null pointer
    println(savedMovie)



}

fun saveMovie(movie: Movie): Movie {
    return movie.copy(id = 1)
}
