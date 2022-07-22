package com.kotlin.playground.classes

interface CourseRepository {
    val isCoursePersistence: Boolean
    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("saving $course")
        return course.id
    }
}

interface Repository {
    fun getAll(): Any
}

class SqlCourseRepository : CourseRepository, Repository {
    override var isCoursePersistence: Boolean = false
    override fun getById(id: Int): Course {
        return Course(id, " some course")
    }

    override fun save(course: Course): Int {
        isCoursePersistence = true
        return super.save(course)
    }

    override fun getAll(): Any {
        return 10000
    }
}

class NoSqlCourseRepository(override val isCoursePersistence: Boolean) : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(id, " some course")
    }

    override fun save(course: Course): Int {
        println("saving in a different way no sql $course")
        return course.id
    }
}

// Conflicts with method names, this should not happen, smell

interface A {
    fun doSomething() {
        println("something A")
    }
}

interface B {
    fun doSomething() {
        println("something B")
    }
}

class AB: A, B {
    override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("something AB")
    }
}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    val course = sqlCourseRepository.getById(1)
    println(course)
    println("is persistence: ${sqlCourseRepository.isCoursePersistence}")
    sqlCourseRepository.save(course)
    println("is persistence: ${sqlCourseRepository.isCoursePersistence}")
    val noSqlCourseRepository = NoSqlCourseRepository(false)
    val courseNoSql = noSqlCourseRepository.getById(1)
    println(courseNoSql)
    noSqlCourseRepository.save(course)
    val ab = AB()
    ab.doSomething()
}