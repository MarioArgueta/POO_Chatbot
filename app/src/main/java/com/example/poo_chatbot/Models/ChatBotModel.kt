package com.example.poo_chatbot.Models

class ChatBotModel {
    lateinit var response: String
    lateinit var id: String
    var result: Int = 0
    lateinit var mgs: String

    constructor(response: String, id: String, result: Int, mgs: String) {
        this.response = response
        this.id = id
        this.result = result
        this.mgs = mgs
    }

    constructor() {}
}