package com.kotlin.playground.classes

//Adding the data keyword will automatically generates the equals, hashCode and toString methods
data class Course(val id: Int, val name: String)

fun main() {
    val course = Course(1, "aprendiendo algo")

    // This will be printing a nice thing due toString, expanding the object and printing the properties
    println(course)

    val anotherCourse = course.copy(id = 3)

    println(anotherCourse)

}