package com.example.mylib

fun main() { //gradle,repositories, dependancies

    try {
        var numOfInstances: Int = 10
        val barnMB = Hlev("HlevMB", 30, Location("Slovenia", "Podravska", "Maribor"))
        barnMB.addRandomPig(15)
        barnMB.sort()
        println(barnMB)
        println(Date().toDate("23-10-2021").toString())


    } catch (ex: BarnFullException) {
        println(ex.message)
    }



}