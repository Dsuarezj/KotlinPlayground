package com.kotlin.playground.classes

class Item() {
    var name: String = ""

    constructor(_name: String): this() {
        name = _name
    }
}

fun main(){
    val item = Item("cosa")
    println("Item name ${item.name}")
    item.name = "otra cosa"
    println("Item name ${item.name}")
}