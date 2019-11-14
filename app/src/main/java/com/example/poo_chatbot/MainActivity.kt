package com.example.poo_chatbot

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.provider.Settings.Global.getString
import android.view.View
import android.widget.EditText
import android.widget.ListView
import com.example.poo_chatbot.Adapter.CustomAdapter
import com.example.poo_chatbot.Helper.HttpDataHanler
import com.example.poo_chatbot.Models.ChatModel
import com.example.poo_chatbot.Models.ChatBotModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*

abstract class MainActivity : AppCompatActivity() {

    abstract var listView: ListView
    lateinit var editText: EditText
    var list_chat: MutableList<ChatModel> = ArrayList()
    abstract var btn_send_message: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        listView = findViewById(R.id.List_of_message) as ListView
        editText = findViewById(R.id.User_Message) as EditText
        btn_send_message = findViewById(R.id.fab) as FloatingActionButton

        btn_send_message.setOnClickListener { view ->
            fun onClick(v: View){
                val text = editText.text.toString()
                val model = ChatModel(text, true)//Usuario envia los chat
                list_chat.add(model)
                ChatBotAPI().execute(list_chat)

                editText.setText("") //Remueve el mensaje del usuario
            }

            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
        }
    }
     private class ChatBotAPI : AsyncTask<List<ChatModel>, Void, String>() {
         lateinit var editText: EditText
         lateinit var listView: ListView
         lateinit var customAdapter : CustomAdapter
         internal var stream: String? = null
         lateinit var models: MutableList<ChatModel>
         internal var text = editText.text.toString()

         override fun doInBackground(vararg params: List<ChatModel>?): String {
             val url = String.format("http://sandbox.api.simsimi.com/request.p?key=%s&lc=en&ft=1.0&text=%s", getString(R.string.Chatbot_API), text)
             models = params[0] as MutableList<ChatModel>
             val httpDataHandler = HttpDataHanler()
             stream = httpDataHandler.GetHTTPData(url)
             return stream.toString()
         }

         override fun onPostExecute(s: String) {
             /*        val gson = Gson()
        val apiResponse = gson.fromJson(response, ApiResponse::class.java)*/
             val gson = Gson()

             val response = gson.fromJson(s, ChatBotModel::class.java)

             val chatModel =
                 ChatModel(response.getResponse(), false) //Captura la respuesta de la API
             models.add(chatModel)
             val adapter = customAdapter(models,applicationContext)
             listView.setAdapter(adapter)
         }
     }
    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }*/

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}
