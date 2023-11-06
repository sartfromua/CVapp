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
            val mail = getString(R.string.emailRecipient)
            val emailsubject = getString(R.string.emailSubject)

            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.setData(Uri.parse("mailto:"))
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(mail))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailsubject)
            try {
                startActivity(Intent.createChooser(emailIntent, "Choose Email Client..."))
            } catch (e: Exception) {
                Log.e("XXXXX", e.message.toString())
            }
        }

    }
}