package com.kotlin.playground.startpack.classes.inheritance

// you can extend only from one class
class Student(name: String) : User(name) {
    override val accessLevel: String = "student"
    override fun login() {
        super.login() // This line will call what is in the original login fun
        println("do things for students")
    }

    // this is due kotlin does not support static keyword
    companion object {
        val levels = 5
        fun something() = "some fun"
    }

}

class Instructor(name: String) : User(name) {
    override val accessLevel: String = "instructor"
}

class Visitor(name: String) : User(name) {
}

fun main() {
    println(Student.something() + Student.levels)
    val student = Student("Bob")
    student.login()
    student.nonOverrideFun()
    println("access level for ${student.name} is ${student.accessLevel}")
    val instructor = Instructor("Alice")
    instructor.login()
    println("access level for ${instructor.name} is ${instructor.accessLevel}")
    val visitor = Visitor("Eve")
    println("access level for ${visitor.name} is ${visitor.accessLevel}")

}