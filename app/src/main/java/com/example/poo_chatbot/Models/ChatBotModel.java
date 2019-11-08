package com.example.poo_chatbot.Models;

public class ChatBotModel {
    public String response;
    public String id;
    public int result;
    public String mgs;

    public ChatBotModel(String response, String id, int result,String mgs){
        this.response = response;
        this.id = id;
        this.result = result;
        this.mgs  = mgs;
    }
    public ChatBotModel(){
    }

    public String getResponse(){
        return response;
    }

    public void setResponse(String response){
        this.response = response;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public int getResult(){
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMgs() {
        return mgs;
    }

    public void setMgs(String mgs) {
        this.mgs = mgs;
    }
}
