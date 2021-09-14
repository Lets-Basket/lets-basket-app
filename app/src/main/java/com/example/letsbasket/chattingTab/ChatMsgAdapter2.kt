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
import com.example.letsbasket.chattingTab.ChatMsgItem
import com.example.letsbasket.chattingTab.ChatResponse
import com.example.letsbasket.chattingTab.ChattingMsgActivity
import com.example.letsbasket.itemDetail.ItemActivity

class ChatMsgAdapter2(private val context: Context): RecyclerView.Adapter<ChatMsgAdapter2.ViewHolder>() {

    var datas = mutableListOf<ChatMsgItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatMsgAdapter2.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_chat_msg2, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ChatMsgAdapter2.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val date_tv2: TextView = itemView.findViewById(R.id.date_tv2)
        private val content_tv2: TextView = itemView.findViewById(R.id.content_tv2)

        fun bind(item: ChatMsgItem){
            date_tv2.text = item.date_tv2
            content_tv2.text = item.content_tv2
        }
    }
}