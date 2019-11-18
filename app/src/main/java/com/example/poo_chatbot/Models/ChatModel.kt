package com.example.poo_chatbot.Models

import android.R.id.message
import android.R.id.message





class ChatModel {
    var messege: String
    var isSend: Boolean = false

    constructor(messege: String, isSend: Boolean) {
        this.messege = messege
        this.isSend = isSend
    }
    fun setMessage(message: String) {
        this.messege = message
    }
    fun getMessage(): String {
        return messege
    }

}