package com.example.naruto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val username= intent.getStringExtra(constants.USER_NAME)
        val totalquestion = intent.getIntExtra(constants.TOTAL_QUESTIONS,0)
        val correctanswers= intent.getIntExtra(constants.CORRECT_ANSWERS,0)
        val tvname = findViewById<TextView>(R.id.tv_name)
        val tvscore = findViewById<TextView>(R.id.tv_score)
        tvname.text = username
        tvscore.text= "Score => $correctanswers / $totalquestion"
        val btnfinish = findViewById<Button>(R.id.btn_finish)
        btnfinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}