package com.example.cvapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            startActivity(Intent(applicationContext, BigPhoto::class.java))
        }
        shortInfo.setOnClickListener {
            startActivity(Intent(applicationContext, MoreInfoActivity::class.java))
        }
        phone.setOnClickListener {
            val number = getString(R.string.phoneNumber)
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${number}")))
        }
        email.setOnClickListener {
            val mail = getString(R.string.email)
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${mail}")
                    .buildUpon()
                    .appendQueryParameter("Subject", "saf").
                    appendQueryParameter("mailto", mail)
                        .build()
//                putExtra(Intent.EXTRA_SUBJECT, "Invitation to participate in the interview")
            }
            startActivity(Intent.createChooser(intent, "Choose Email Client..."))
        }

    }
}