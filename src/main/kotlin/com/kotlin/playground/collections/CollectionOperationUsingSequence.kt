package com.kotlin.playground.collections

import com.kotlin.playground.dataset.Course
import com.kotlin.playground.dataset.CourseCategory
import com.kotlin.playground.dataset.courseList

fun main() {
    val bigNameList = listOf("alex", "ben", "chloe")
        .asSequence()
        .filter { it.length >=4 }
        .map { it.uppercase() }
        .toList()
    println("upper case for big names $bigNameList")
    val devPredicate = {
            c: Course -> c.category == CourseCategory.DEVELOPEMENT
    }
    exploreNameUsingSequence(courseList(), devPredicate)

    val range = 1 .. 1_000_000_000
    range
        .asSequence() // without this we got a Java heap space this is due map will try to store all the result in a intermediate variable, with sequence we start process one by one
        .map { it.toDouble() }
        .take(40) // we take only the 40 elements but without the sequence this will still fail due map will try to store all the elements in a intermediate variable
        .forEach{
            println("Values is: $it")
        }

}

fun exploreNameUsingSequence(courseList: MutableList<Course>, predicate: (Course) -> Boolean){
    courseList
        .asSequence() // performance better for bigger list
        .filter(predicate)
        .forEach {
            println("Courses: $it")
        }
}