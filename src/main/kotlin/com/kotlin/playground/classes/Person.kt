package com.kotlin.playground.classes

class Person(val name: String = "", val age: Int = 0) {
    var email: String = ""

    // It is prefer to use primary constructor, try to avoid this types of constructors
    constructor(_email: String, _name: String = "", _age: Int = 0): this(_name, _age){
        email =_email
    }
    fun action() {
        println("Person walks")
    }
}

fun main() {
    val person = Person("Alice", 42)
    person.action()
    println("name: ${person.name} and age ${person.age}")
    val anotherPerson = Person()
    println("name: ${anotherPerson.name} and age ${anotherPerson.age}")
    val personWithEmail = Person(_email = "@.com", _age = 43)
    println("name: ${personWithEmail.name} and age ${personWithEmail.age} and email ${person.email}")

}