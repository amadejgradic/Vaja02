package com.example.vaja02

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mylib.*
import com.example.vaja02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val barnMB = Hlev("HlevMS", 30, Location("Slovenia", "Podravska", "Maribor"))
    var getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                Log.i(
                    "zadeva:",
                    "Data from vnos activity:  ${data?.getStringExtra("type")} ${
                        data?.getStringExtra("ID")
                    } ${data?.getStringExtra("name")} ${data?.getStringExtra("weight")} ${
                        data?.getStringExtra(
                            "date"
                        )
                    }"
                )
                val typeOfAnimalInput = data?.getStringExtra("type").toString()
                val ID = data?.getStringExtra("ID").toString()
                val name = data?.getStringExtra("name").toString()
                val weight = data?.getStringExtra("weight").toString()
                val date = data?.getStringExtra("date").toString()

                try {
                    when {
                        typeOfAnimalInput == "Pig" -> barnMB.add(
                            Pig(
                                ID.toIntOrNull() ?: 0,
                                name,
                                Date().toDate(date),
                                weight.toDoubleOrNull() ?: 0.0
                            )
                        )
                        typeOfAnimalInput.toString() == "Cow" -> barnMB.add(
                            Cow(
                                ID.toIntOrNull() ?: 0,
                                name,
                                Date().toDate(date),
                                weight.toDoubleOrNull() ?: 0.0
                            )
                        )

                    }
                    Log.i("zadevek", barnMB.size().toString())
                } catch (ex: Exception) {
                    Log.i("UPS", ex.message.toString())
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onOpenVnosActivity(v: android.view.View) {
        val intent = Intent(this, VnosActivity::class.java)
        getContent.launch(intent)
        //startActivity(intent)

    }

    fun onOpenAboutActivity(v: android.view.View) {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

}