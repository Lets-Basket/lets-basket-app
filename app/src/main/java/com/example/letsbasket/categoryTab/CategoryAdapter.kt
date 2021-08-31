package com.example.letsbasket.categoryTab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.letsbasket.R

class CategoryAdapter(private val context: Context): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var datas = mutableListOf<ItemsByCat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val postTitle: TextView = itemView.findViewById(R.id.postTitle)
        private val postPrice: TextView = itemView.findViewById(R.id.postPrice)
        private val postImg: ImageView = itemView.findViewById(R.id.postImage)

        fun bind(item: ItemsByCat){
            postTitle.text = item.title
            postPrice.text = item.price.toString()
            //Glide.with(itemView).load(item.img)into(postImg)
        }

    }
}