package com.kotlin.playground.startpack.scopeFunction

import com.kotlin.playground.startpack.classes.Course
import com.kotlin.playground.startpack.classes.CourseCategory

fun main() {
    exploreApply()
    exploreAlso()
    exploreAlsoAndApply()
    exploreLet()
    exploreWith()
    exploreRun()
}

fun exploreRun() {
    var numbers: MutableList<Int>? = null
    val result = numbers.run {
        numbers = mutableListOf(1, 2, 3, 4)
        numbers?.sum()
    }
    println("run result is: $result")

    // run some arbitary code and return the result
    val length = run {
        val name = "Alice"
        println(name)
        name.length
    }
    println("Run lenght is $length")
}

fun exploreWith() {
    val numbers = mutableListOf(1, 2, 3, 4)
    val result = with(numbers) {
        println("size ${numbers.size}")
        val list = numbers.plus(6)
        list.sum()
    }

    println("result with = $result")
    // since we are on the context we can rewrite like this
    val result1 = with(numbers) {
        println("size this refer numbers, but no neeed to be write it explicit: $size")
       sum()
    }

    println("result with = $result1")

}

fun exploreLet() {
    val numbers = mutableListOf(1, 2, 3, 4)
    val result = numbers
        .map { it * 2 }
        .filter { it > 5 }
        .let {
            println(it)
            it.sum() //This is
        }
    println("result is: $result")

    var name: String? = null

    val result1 = getUppercase(name)
    println("With null name: $result1")

    name = "Alice"
    val result2 = getUppercase(name)
    println("with name: $result2")
}

private fun getUppercase(name: String?): String? {
    return name?.let {
        println(it)
        it.uppercase()
    }
}

fun exploreAlsoAndApply() {
    val course = Course(
        1,
        "some course"
    ).apply {
        courseCategory = CourseCategory.DESIGN
        // this.courseCategory
    }.also {
        println("Course is $it")
    }
}

fun exploreAlso() {
    val course = Course(
        1,
        "some course"
    ).also {
        println("Course is $it")
    }
}

fun exploreApply() {
    val course = Course(
        1,
        "some course"
    ).apply {
        courseCategory = CourseCategory.DESIGN
        // this.courseCategory
    }
    println(course)
}
