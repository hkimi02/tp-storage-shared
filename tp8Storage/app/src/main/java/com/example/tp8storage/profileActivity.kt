package com.example.tp8storage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class profileActivity : AppCompatActivity() {
    lateinit var name:TextView
    lateinit var logoutbtn:Button
    lateinit var nPre: SharedPreferences
    lateinit var nEditor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        logoutbtn=findViewById(R.id.button)
        nPre = PreferenceManager.getDefaultSharedPreferences(this)
        nEditor = nPre.edit()
        name = findViewById(R.id.textView)
        val intent:Intent= getIntent()
        name.text=name.text.toString() + intent.getStringExtra("name")
        logoutbtn.setOnClickListener(){
                nEditor.clear();
                nEditor.commit()
            startActivity(Intent(this, MainActivity::class.java));
        }
    }
}