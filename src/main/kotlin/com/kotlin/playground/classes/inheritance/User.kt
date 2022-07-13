package com.kotlin.playground.classes.inheritance

// the open modifier make this class be extendable, all classes are set as final by defult if you don't "open them"
open class User(val name: String) {
    open val accessLevel: String = "basic"
    open fun login(){
        println("inside user login for $name")
    }

    fun nonOverrideFun(){
        println("this can not be modify because it does not have the open modifier")
    }
}
