package com.kotlin.playground.collections

import com.kotlin.playground.dataset.Course
import com.kotlin.playground.dataset.CourseCategory
import com.kotlin.playground.dataset.KAFKA
import com.kotlin.playground.dataset.courseList

fun main() {
    val courseList = courseList()
    val devPredicate = {
        c: Course -> c.category == CourseCategory.DEVELOPEMENT
    }
    exploreFilter(courseList, devPredicate)
    val designPredicate = {
            c: Course -> c.category == CourseCategory.DESIGN
    }
    exploreFilter(courseList, designPredicate)
    exploreMap(courseList,designPredicate)
    val list = listOf(listOf(1,2,3), listOf(4,5,6))
    val mapResult = list.map { innerList -> innerList.map {
        it.toDouble()
    } }

    println("map Result: $mapResult")

    val flatMapResult = list.flatMap { innerList -> innerList.map {
        it.toDouble()
    } }

    println("flatmap Result: $flatMapResult")

    val course = exploreFlatMap(courseList, KAFKA)
    println("courses filter: $course")
}

fun exploreFlatMap(courseList: MutableList<Course>, topic: String): List<String> {
    return courseList.flatMap { course ->
        val courseName = course.name
        course.topicsCovered.filter {
            it == topic
        }.map {
            println("inside map, inside flatmap: $it")
            courseName
        }
    }
}

fun exploreMap(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    val courses = courseList
        .filter(predicate) // in here we are not using the lambda sintaxis {} but calling filter function () and passing the predicate
        .map {
            "${it.name} - ${it.category}"
        }
        .forEach{
            println("courses names: $it")
        }

    println("courses after foreach: $courses") // this won't print anything since foreach does not return anything
}

fun exploreFilter(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    val developmentCourse = courseList
        .filter { predicate.invoke(it) }
        .forEach{
            println("filtered courses: $it")
        }
}
