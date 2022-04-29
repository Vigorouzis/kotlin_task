package com.example.kotlin_task.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_task.R
import com.example.kotlin_task.domain.Cat


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CAT = "EXTRA_CAT"
    }

    private var mStartForResult = registerForActivityResult(
        StartActivityForResult()
    ) { result ->

        val ageText: TextView = findViewById(R.id.catAge)
        val growthText: TextView = findViewById(R.id.catGrowth)
        val weightText: TextView = findViewById(R.id.catWeight)
        val breedText: TextView = findViewById(R.id.catBreed)
        if (result.resultCode == RESULT_OK) {
            val intent: Intent? = result.data
            val cat: Cat = intent?.getParcelableExtra(EXTRA_CAT)!!
            ageText.text = "Порода: ${cat.age}"
            growthText.text = "Возраст: ${cat.growth}"
            weightText.text = "Рост: ${cat.weight}"
            breedText.text = "Вес: ${cat.breed}"

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val catImage: ImageView = findViewById(R.id.catImage)
        val ageText: TextView = findViewById(R.id.catAge)
        val growthText: TextView = findViewById(R.id.catGrowth)
        val weightText: TextView = findViewById(R.id.catWeight)
        val breedText: TextView = findViewById(R.id.catBreed)

        val arguments = intent.extras

        val cat: Cat? = arguments?.getParcelable("Cat") as Cat?

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { it ->
            val intent = Intent(it.context, ChangeDataActivity::class.java)
            intent.putExtra("data", cat)
            mStartForResult.launch(intent);
        }





        cat?.let { catImage.setImageResource(it.catResource) }
        ageText.text = "Возраст: ${cat?.age}"
        growthText.text = "Рост: ${cat?.growth}"
        weightText.text = "Вес: ${cat?.weight}"
        breedText.text = "Порода: ${cat?.breed}"

    }
}