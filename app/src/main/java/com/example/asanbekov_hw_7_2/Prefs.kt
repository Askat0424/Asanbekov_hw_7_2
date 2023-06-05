package com.example.asanbekov_hw_7_2

import android.content.Context


class Pref (context: Context) {

    private val pref = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    fun saveList(json : String){
        pref.edit().putString("json_list" , json).apply()
    }

    fun getList() = pref.getString("json_list" , "lala")
}