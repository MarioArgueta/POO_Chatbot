package com.example.poo_chatbot.Helper

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class HttpDataHanler {
    fun GetHTTPData(urlString: String): String? {
        try {
            val url = URL(urlString)
            val urlConnection = url.openConnection() as HttpURLConnection

            if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                val `in` = BufferedInputStream(urlConnection.inputStream)

                val r = BufferedReader(InputStreamReader(`in`))
                val sb = StringBuilder()
                var line: String
                while ((line = r.readLine()) != null)
                    sb.append(line)
                stream = sb.toString()
                urlConnection.disconnect()
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {

        }
        return stream
    }

    companion object {
        internal var stream: String? = null
    }
}