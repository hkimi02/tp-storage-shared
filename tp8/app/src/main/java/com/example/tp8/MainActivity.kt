package com.example.tp8

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {
    lateinit var mEditText:EditText
    lateinit var saveButton:Button
    lateinit var loadButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var File_Name="example.txt"
        mEditText=findViewById(R.id.editTextText2)
        saveButton=findViewById(R.id.button2)
        loadButton=findViewById(R.id.button3)
        saveButton.setOnClickListener {
            val text: String = mEditText.getText().toString()
            var fo: FileOutputStream?=null
            try {
                fo = openFileOutput(File_Name, AppCompatActivity.MODE_PRIVATE)
                fo.write(text.toByteArray())
            } catch (e: IOException) {
                e.printStackTrace()
            }
            mEditText.getText().clear()
            Log.i("Saved to", "$filesDir/$File_Name")
            if (fo != null) {
                try {
                    fo.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        loadButton.setOnClickListener{
            var fis = openFileInput(File_Name)
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)
            val sb = StringBuilder()
            var text: String?
            while (br.readLine().also { text = it } != null) {
                sb.append(text).append("\n")
            }
            mEditText.setText(sb.toString())
        }
    }
}
