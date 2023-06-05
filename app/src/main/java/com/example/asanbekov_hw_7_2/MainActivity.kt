package com.example.asanbekov_hw_7_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    val listOfNote = mutableListOf<Note>()
    var listOfNoteJson = ""
    var pref : Pref ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = Pref(this)

        for (i in 1 ..20){
            listOfNote.add(Note(i,"l:$i","d:$i"))
        }

        Log.e("ololo" , "list : $listOfNote")

        pref!!.saveList(Gson().toJson(listOfNote))
        val listFromJson = Gson().fromJson(
            pref!!.getList(),
            object : TypeToken <List<Note>>(){}.type
        )as List<Note>
    }
}