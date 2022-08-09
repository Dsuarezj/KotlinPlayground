package com.kotlin.playground.startpack.classes

import java.lang.IllegalArgumentException

class Item() {
    var name: String = ""
    var price: Double = 0.0
        // get() = field // this is define as default no need to declare it again only if you want to add custom logic
        get() {
            println("Do something else before return")
            return field
        }
        set(value) {
            if(value >= 0.0) field = value else throw IllegalArgumentException("no negative prices")
        }

    constructor(_name: String): this() {
        name = _name
    }
}

fun main(){
    val item = Item("cosa")
    println("Item name ${item.name}")
    item.name = "otra cosa"
    item.price = 10.0
    println("Item name ${item.name} with price ${item.price}")
    item.price = -1.0

}