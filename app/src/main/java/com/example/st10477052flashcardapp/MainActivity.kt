package com.example.st10477052flashcardapp

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btStart = findViewById<Button>(R.id.bt_start)
        btStart.setOnClickListener {
            val intent = Intent(this, FlashCardScreen::class.java)// ALLOWS US TO USE INTENT TO SWAP SCREENS WITH A CLICK OF A BUTTON
            startActivity(intent)
        }

    }
}
// https://www.youtube.com/watch?v=2gljhNFKimk (Kotlin - Open a New Activity with a Button Click in Android Studio | Kotlin | 2021 | #2 Foxandriod,2021)