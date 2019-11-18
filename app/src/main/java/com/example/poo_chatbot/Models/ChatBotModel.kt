package com.example.poo_chatbot.Models

class ChatBotModel {
    private var response: String
    private var id: String
    var result: Int = 0
    private var mgs: String

    constructor(response: String, id: String, result: Int, mgs: String) {
        this.response = response
        this.id = id
        this.result = result
        this.mgs = mgs
    }

    fun getResponse(): String{
        return response
    }
    fun setMessage(response: String) {
        this.response = response
    }
    fun getMsg(): String{
        return mgs
    }
    fun setMgs(msg: String){
        this.mgs = mgs
    }
    fun getId(): String{
        return id
    }
    fun setId(id: String){
        this.id = id
    }


}