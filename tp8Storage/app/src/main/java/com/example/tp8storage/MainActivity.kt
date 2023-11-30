package com.example.tp8storage


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var nPre: SharedPreferences
    lateinit var nEditor: SharedPreferences.Editor
    lateinit var nName: EditText
    lateinit var nPass:EditText
    lateinit var btnLogin: Button
    lateinit var nCheckBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin=findViewById(R.id.btnLogin)
        nName=findViewById(R.id.nName)
        nPass=findViewById(R.id.nPass)
        nCheckBox=findViewById(R.id.nCheckBox)
        nPre = PreferenceManager.getDefaultSharedPreferences(this)
        nEditor = nPre.edit()
        checkSharedPreferences()
        btnLogin.setOnClickListener{
            if(nCheckBox.isChecked) {
                nEditor.putString(getString(R.string.chekbox), "True")
                nEditor.commit()
                val name = nName.text.toString()
                nEditor.putString(getString(R.string.name), name)
                nEditor.commit()
                val password = nPass.text.toString()
                nEditor.putString(getString(R.string.password), password)
                nEditor.commit()
            }
            val name=nName.text.toString()
            startActivity(Intent(this, profileActivity::class.java).apply {
                putExtra("name",name);
            });
        }
    }

    fun checkSharedPreferences() {
        val checkbox: String? = nPre?.getString(getString(R.string.chekbox), "False")
        val name: String? = nPre?.getString(getString(R.string.name), "")
        val password: String? = nPre?.getString(getString(R.string.password), "")
        nName?.setText(name)
        nPass?.setText(password)
        if (checkbox == "True") {
            nCheckBox?.isChecked=true
            startActivity(Intent(this, profileActivity::class.java).apply {
                putExtra("name",name);
            });
        } else {
            nCheckBox?.isChecked = false
        }
    }
}
