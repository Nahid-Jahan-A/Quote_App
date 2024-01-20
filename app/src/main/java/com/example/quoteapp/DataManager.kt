package com.example.quoteapp

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.quoteapp.models.Quote
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

object DataManager {

    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null

    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun readJSONFromAssets(context: Context, path: String) {
        val identifier = "[ReadJSON]"
        try {
            val file = context.assets.open(path)
            Log.i(
                identifier,
                " Found File: $file.",
            )
            val bufferedReader = BufferedReader(InputStreamReader(file))
            val stringBuilder = StringBuilder()
            bufferedReader.useLines { lines ->
                lines.forEach {
                    stringBuilder.append(it)
                }
            }
            Log.i(
                identifier,
                "getJSON stringBuilder: $stringBuilder.",
            )
            val jsonString = stringBuilder.toString()
            isDataLoaded.value = true
            Log.i(
                identifier,
                "JSON as String: $jsonString.",
            )
            val gson = Gson()
            data = gson.fromJson(jsonString, Array<Quote>::class.java)
        } catch (e: Exception) {
            Log.e(
                identifier,
                "Error reading JSON: $e.",
            )
            e.printStackTrace()
        }
    }

    fun switchPages(quote: Quote?) {
        if(currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }

}