package com.example.naruto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var btnsubmit = findViewById(R.id.btn_submit) as Button
        var etname = findViewById(R.id.et_name) as EditText
        btnsubmit.setOnClickListener(){
            if(etname.text.toString().isEmpty()){
                Toast.makeText(this, "please enter your name" , Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, Quizquestions::class.java)
                intent.putExtra(constants.USER_NAME,etname.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}