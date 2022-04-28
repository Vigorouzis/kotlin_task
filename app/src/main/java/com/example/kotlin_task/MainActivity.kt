package com.example.kotlin_task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_task.domain.Cat
import com.example.kotlin_task.views.CustomRecyclerAdapter


class MainActivity : AppCompatActivity() {
    private var cats: ArrayList<Cat> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialData()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CustomRecyclerAdapter(cats)

        val swipeGesture = object : SwipeGesture(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when (direction) {
                    ItemTouchHelper.LEFT ->
                        adapter.deleteItem(viewHolder.absoluteAdapterPosition)

                    ItemTouchHelper.RIGHT -> {
                        val newItem = cats[viewHolder.absoluteAdapterPosition]
                        adapter.addItem(newItem, cats.size)
                    }

                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeGesture)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        recyclerView.adapter = adapter
    }

    private fun setInitialData() {
        cats.add(Cat(5, 110, 15, "Британская", R.drawable.british))
        cats.add(Cat(6, 110, 15, "Мейн-кун", R.drawable.mein_kun))
        cats.add(Cat(3, 110, 15, "Манчкин", R.drawable.munchkin))
        cats.add(Cat(2, 110, 15, "Персидская", R.drawable.persid))

    }

}