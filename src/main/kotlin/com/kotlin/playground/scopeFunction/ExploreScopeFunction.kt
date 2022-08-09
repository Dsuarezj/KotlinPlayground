package com.kotlin.playground.scopeFunction

import com.kotlin.playground.classes.Course
import com.kotlin.playground.classes.CourseCategory

fun main() {
    exploreApply()
    exploreAlso()
    exploreAlsoAndApply()
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
