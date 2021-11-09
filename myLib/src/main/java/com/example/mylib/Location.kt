package com.example.mylib

class Location(var country: String, var region: String, var city: String) {
    override fun toString(): String {
        return "Country:$country\n Region:$region\n City:$city"
    }

    fun show() {
        println("Country:$country Region:$region City:$city")
    }
}