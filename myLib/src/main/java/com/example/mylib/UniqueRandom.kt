package com.example.mylib

import kotlin.random.Random
import kotlin.random.nextInt

fun getUniqueRandoms(from: Int, to: Int) = sequence {
    val seen = mutableSetOf<Int>()
    while (true) {
        val next = Random.nextInt(from..to)
        // add returns true if it wasn't already in the set - i.e. it's not a duplicate
        if (seen.add(next)) yield(next)
    }
}