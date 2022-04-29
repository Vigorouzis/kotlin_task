package com.example.kotlin_task.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlin_task.R
import com.example.kotlin_task.domain.Cat
//класс для редактирования котов
class ChangeDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_data)


        val ageEditText: TextView = findViewById(R.id.catAgeEditText)
        val growthEditText: TextView = findViewById(R.id.catGrowthEditText)
        val weightEditText: TextView = findViewById(R.id.catWeightEditText)
        val breedEditText: TextView = findViewById(R.id.catBreedEditText)

        val arguments = intent.extras

        val cat: Cat = arguments?.getParcelable<Cat>("data")!!
        ageEditText.text = cat.age.toString()
        growthEditText.text = cat.growth.toString()
        weightEditText.text = cat.weight.toString()
        breedEditText.text = cat.breed

        val fab: View = findViewById(R.id.fabEdit)
        fab.setOnClickListener {

            cat.age = ageEditText.text.toString().toInt()
            cat.growth = growthEditText.text.toString().toInt()
            cat.weight = weightEditText.text.toString().toInt()
            cat.breed = breedEditText.text.toString()

            val intent = Intent()
            intent.putExtra("EXTRA_CAT", cat);
            setResult(RESULT_OK, intent)
            finish()
        }


    }
}