package com.example.cvapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phone = findViewById<TextView>(R.id.textPhoneNumber)
        val email = findViewById<TextView>(R.id.textEmail)
        val picture = findViewById<ImageView>(R.id.pictureImageView)
        val shortInfo = findViewById<TextView>(R.id.textInfoShort)
        picture.setOnClickListener {
            val intent = Intent(applicationContext, BigPhoto::class.java)
            startActivity(intent)
        }

    }
}