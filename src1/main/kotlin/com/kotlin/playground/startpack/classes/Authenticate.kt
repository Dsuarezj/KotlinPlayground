package com.kotlin.playground.startpack.classes

// This is helpful when trying to implement Singleton pattern, so you don't have to create a instance of the class everytime, you just called it
object Authenticate {
    fun authenticate(userName: String, password: String){
        println("Authenticating user $userName")
    }
}

fun main() {
    Authenticate.authenticate("usuario", "pass")
}