package com.example.letsbasket.categoryTab

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.letsbasket.R
import com.example.letsbasket.chattingTab.ChattingMsgActivity
import com.example.letsbasket.itemDetail.ItemActivity

class ChattingAdapter(private val context: Context): RecyclerView.Adapter<ChattingAdapter.ViewHolder>() {

    var datas = mutableListOf<ItemsByCat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChattingAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.chatting_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ChattingAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val postTitle: TextView = itemView.findViewById(R.id.postTitle)
        private val postPrice: TextView = itemView.findViewById(R.id.postPrice)
        private val postImg: ImageView = itemView.findViewById(R.id.postImage)

        fun bind(item: ItemsByCat){
            postTitle.text = item.title
            postPrice.text = item.price.toString()+"원"
            Glide.with(itemView).load(item.img).error(R.drawable.default_img).into(postImg)

            // 클릭 이벤트 추가
            itemView.setOnClickListener{
                Intent(context, ChattingMsgActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
        }
    }
}