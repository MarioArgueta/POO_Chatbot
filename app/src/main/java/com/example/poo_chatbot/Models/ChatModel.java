package com.example.poo_chatbot.Models;

public class ChatModel {
    public String messege;
    public boolean isSend;

    public ChatModel(String messege, boolean isSend){
        this.messege = messege;
        this.isSend  = isSend;
    }

    public ChatModel(){
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
