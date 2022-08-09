package com.kotlin.playground.startpack.collections

import com.kotlin.playground.startpack.dataset.Course
import com.kotlin.playground.startpack.dataset.CourseCategory
import com.kotlin.playground.startpack.dataset.KAFKA
import com.kotlin.playground.startpack.dataset.courseList

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

    exploreHashMap()
    collectionNullability()
}

fun collectionNullability() {
    var list: MutableList<String>? = null
    list = mutableListOf()
    list.add("Alice")
    list.forEach {
        println("value of nullable list: $it")
    }

    val listWithNullElements: List<String?> = listOf("Alice", null, "Bob")
    listWithNullElements.forEach{
        println("Length is: ${it?.length}")
    }
}

fun exploreHashMap() {
    val nameAge = mutableMapOf("dilip" to 33, "alice"  to 23)
    nameAge.forEach{
        (k,v) ->
        println("key: $k, value: $v")
    }
    println(nameAge["alice"])
    nameAge.getOrElse("Bob") {"default"}
    println(nameAge.containsKey("abc"))

    val filterMap = nameAge.filterKeys { it.endsWith("e") }
        .map { it.key.uppercase() }

    println("Filter hash map $filterMap")

    val oldest = nameAge.maxByOrNull { it.value }
    println("Oldest age $oldest")

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
