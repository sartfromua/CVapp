package com.example.cvapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView

class MoreInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)
        findViewById<ImageView>(R.id.imageBackInfo).setOnClickListener{
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}