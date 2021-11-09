package com.example.mylib

class Pig(
    override val ID: Int,
    override var Ime: String,
    override val datumVpisa: Date,
    var telesnaTeza: Double
) : Animal(ID, Ime, datumVpisa) {
    override val type: String = "Prasic"

    override fun toString(): String {
        return "Vrsta zivali: $type, ID:$ID, Teza: ${"%.2f".format(telesnaTeza)}kg, Ime:$Ime, Vpisan: $datumVpisa\n"

    }

}