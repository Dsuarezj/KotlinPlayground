package com.kotlin.playground.cast

import com.kotlin.playground.classes.Course
import com.kotlin.playground.classes.CourseCategory

fun checkType(type: Any) {
    when (type) {
        is Course -> {
            println(type)
        }
        is String -> {
            println(type.lowercase())
        }
    }
}
fun main(){
    val course =  Course(1, "A", CourseCategory.DEVELOPMENT)
    checkType(course)
    checkType("THIS IS A STRING")
    castNumber(1.0)
    // castNumber(1) // this will throw a type casting
    val number = 1
    println(castNumber(number.toDouble()))
}

fun castNumber(d: Any) {
    when(d){
        d as Double -> println("value is double")
    }

}
