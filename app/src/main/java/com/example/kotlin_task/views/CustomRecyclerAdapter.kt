package com.example.kotlin_task.views

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_task.R
import com.example.kotlin_task.domain.Cat
import com.example.kotlin_task.presentation.DetailActivity

class CustomRecyclerAdapter(private val cats: ArrayList<Cat>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catImage: ImageView = itemView.findViewById(R.id.catImage)
        val smallTextView: TextView = itemView.findViewById(R.id.breed)
        val largeTextView: TextView = itemView.findViewById(R.id.age)
    }

    fun deleteItem(position: Int) {
        cats.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(cat: Cat, position: Int) {
        cats.add(position, cat)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)



        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cat: Cat = cats[position]
        holder.catImage.setImageResource(cat.catResource)
        holder.largeTextView.text = "Возраст: ${cat.age}"
        holder.smallTextView.text = "Порода: ${cat.breed}"

        holder.itemView.setOnClickListener {

            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("Cat", cat)
            it.context.startActivity(intent)

        }

    }

    override fun getItemCount() = cats.size
}