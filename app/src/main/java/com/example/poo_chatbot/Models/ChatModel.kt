package com.example.poo_chatbot.Models

class ChatModel {
    lateinit var messege: String
    var isSend: Boolean = false

    constructor(messege: String, isSend: Boolean) {
        this.messege = messege
        this.isSend = isSend
    }

    constructor() {}
}