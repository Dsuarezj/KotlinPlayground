package com.kotlin.playground.collections

import com.kotlin.playground.dataset.Course
import com.kotlin.playground.dataset.CourseCategory
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
}

fun exploreFilter(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    val developmentCourse = courseList
        .filter { predicate.invoke(it) }
        .forEach{
            println("filtered courses: $it")
        }
}
