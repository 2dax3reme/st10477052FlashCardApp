package com.example.st10477052flashcardapp //All code was written by myself and corrected by gemini, comments were also added by gemini

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultSCreen : AppCompatActivity() {

    private lateinit var tvResultDisplay: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        tvResultDisplay = findViewById(R.id.tvResult)

        // Where score is displayed
        val userScore = intent.getIntExtra("USER_SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)

        if (totalQuestions > 0) {
            tvResultDisplay.text = "Your Score: $userScore / $totalQuestions"
        } else {
            tvResultDisplay.text = "Score: $userScore (Total questions not available)"
        }
        val btReviewQuestions = findViewById<Button>(R.id.btReviewQuestions)
        // displays the answer of the questions
        val Review =
            """Question 1 = True        Question 2 = False          Question 3 = False         Question 4 = True          Question 5 = False """

        btReviewQuestions.setOnClickListener {
            tvResultDisplay.text = Review

    }
        // finishes the app
        val btTerminate = findViewById<Button>(R.id.btTerminate)
        btTerminate.setOnClickListener {
            finish()

        }
    }
}