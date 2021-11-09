package com.example.mylib

class Cow(
    override val ID: Int,
    override var Ime: String,
    override val datumVpisa: Date,
    var telesnaTeza: Double
) : Animal(ID, Ime, datumVpisa) {
    override val type: String = "Krava"

    override fun toString(): String {
        return "Vrsta zivali: $type, ID:$ID, Teza: ${telesnaTeza}kg, Ime:$Ime, Vpisan: $datumVpisa\n"
    }
}
