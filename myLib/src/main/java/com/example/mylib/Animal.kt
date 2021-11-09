package com.example.mylib

abstract class Animal: Comparable<Animal> {
    constructor(ID: Int, Ime: String, Date: Any)
    abstract val type: String
    abstract val ID: Int
    abstract var Ime : String
    abstract val datumVpisa: Date

    override fun compareTo(other: Animal): Int {
        return datumVpisa.compareTo(other.datumVpisa)
    }


}