package com.kotlin.playground.scopeFunction

import com.kotlin.playground.classes.Course
import com.kotlin.playground.classes.CourseCategory

fun main() {
    exploreApply()
    exploreAlso()
    exploreAlsoAndApply()
    exploreLet()
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
