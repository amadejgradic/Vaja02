package com.example.vaja02

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.mylib.Hlev
import com.example.mylib.Location
import com.example.vaja02.databinding.ActivityVnosBinding
import kotlin.system.exitProcess


class VnosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVnosBinding

    val barnMB = Hlev("HlevMS", 30, Location("Slovenia", "Podravska", "Maribor"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVnosBinding.inflate(layoutInflater) //ADD THIS LINE
        setContentView(binding.root);
        val animals = resources.getStringArray(R.array.animals)
        val arrayAdapter = ArrayAdapter(applicationContext, R.layout.dropdown_item, animals)
        binding.autoCompleteTextViewType.setAdapter(arrayAdapter)
    }

    fun btnExit(v: android.view.View) {
        exitProcess(0)
    }

    fun btnAdd(v: android.view.View) {
       /* val typeOfAnimalInput = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextViewType)
        val ID = binding.IDtextInput
        val name = binding.nameTextInput
        val weight = binding.weightTextInput
        val date = binding.dateTextInput
        try {
            when {
                typeOfAnimalInput.text.toString() == "Pig" -> barnMB.add(
                    Pig(
                        ID.text.toString().toIntOrNull() ?: 0,
                        name.text.toString(),
                        Date().toDate(date.text.toString()),
                        weight.text.toString().toDoubleOrNull() ?: 0.0
                    )
                )
                typeOfAnimalInput.text.toString() == "Cow" -> barnMB.add(
                    Cow(
                        ID.text.toString().toIntOrNull() ?: 0,
                        name.text.toString(),
                        Date().toDate(date.text.toString()),
                        weight.text.toString().toDoubleOrNull() ?: 0.0
                    )
                )

            }
        } catch (ex: Exception) {
            Log.i("UPS", ex.message.toString())
        }*/
        val data = Intent()
        data.putExtra("type", binding.autoCompleteTextViewType.text.toString())
        data.putExtra("ID", binding.IDtextInput.text.toString())
        data.putExtra("name", binding.nameTextInput.text.toString())
        data.putExtra("weight", binding.weightTextInput.text.toString())
        data.putExtra("date", binding.dateTextInput.text.toString())
        setResult(RESULT_OK, data)  // nastavi RESULT_OK, lahko tudi RESULT_CANCELED

        binding.autoCompleteTextViewType.text.clear()
        binding.IDtextInput.setText("")
        binding.nameTextInput.setText("")
        binding.weightTextInput.setText("")
        binding.dateTextInput.setText("")
        finish() // zapre aktivnost


    }

    /*fun printObject(v: android.view.View) {
        Log.i("Stevilo v hlevu ", "${barnMB.size()}")

    }*/


}





