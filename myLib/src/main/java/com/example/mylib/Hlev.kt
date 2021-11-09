package com.example.mylib

import io.github.serpro69.kfaker.Faker
import kotlin.random.Random

class Hlev(var naziv: String, var kapaciteta: Int, var lokacija: Location) : Sizable {
    private val list: MutableList<Animal> = mutableListOf()
    override fun size(): Int {
        return list.size
    }

    override fun toString(): String {
        var animals: String = "";
        for (animal in list)
            animals += animal.toString()
        return "$naziv, Lokacija:$lokacija, Kapaciteta: ${list.size}/$kapaciteta\n" + animals
    }

    fun add(animal: Animal) {
        list.add(animal)
        if (list.size > kapaciteta) throw BarnFullException("Stala je polna")
    }

    fun sort() {
        list.sort()
    }

    fun addRandomPig(n: Int) {
        val generate = Faker()
        val randUniqueSequence = getUniqueRandoms(100, 999).take(900).sorted()
        val listOfRandomNumbers = randUniqueSequence.toMutableList()
        repeat(n) {
            list.add(
                Pig(
                    listOfRandomNumbers[0],
                    generate.name.firstName(),
                    Date().makeRandomDate(2000, 2021),
                    Random.nextDouble(50.00, 150.00)
                )
            )
            listOfRandomNumbers.removeFirst()
        }
    }

    fun addRandomCow(n: Int) {
        val generate = Faker()
        val randUniqueSequence = getUniqueRandoms(100, 999).take(900).sorted()
        val listOfRandomNumbers = randUniqueSequence.toMutableList()
        repeat(n) {
            list.add(
                Cow(
                    listOfRandomNumbers[0],
                    generate.name.firstName(),
                    Date().makeRandomDate(2000, 2021),
                    Random.nextDouble(50.00, 150.00)
                )
            )
            listOfRandomNumbers.removeFirst()
        }
    }


}