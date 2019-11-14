package com.example.poo_chatbot.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.poo_chatbot.Models.ChatModel
import com.example.poo_chatbot.R
import com.github.library.bubbleview.BubbleTextView


class CustomAdapter(private val list_chat_models: List<ChatModel>, private val context: Context) :
    BaseAdapter() {
    private val layoutInflater: LayoutInflater

    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return list_chat_models.size
    }

    override fun getItem(position: Int): Any {
        return list_chat_models[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var view: View? = convertView
        if (view == null) {
            if (list_chat_models[position].isSend)
            view = layoutInflater.inflate(R.layout.list_item_message_send, null)
            else
            view = layoutInflater.inflate(R.layout.list_item_message_recv, null)

            val text_message = view!!.findViewById(R.id.text_message) as BubbleTextView
            text_message.setText(list_chat_models[position].messege)
        }
        return view
    }
}
