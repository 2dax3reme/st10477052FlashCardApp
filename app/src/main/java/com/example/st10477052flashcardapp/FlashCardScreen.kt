package com.example.st10477052flashcardapp //All code was written by myself and corrected by gemini, comments were also added by gemini

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashCardScreen : AppCompatActivity() {

    private var counter = 0
    private var currentNumber = 0
    private lateinit var tvQuestion: TextView
    private lateinit var btTrue: Button
    private lateinit var btFalse: Button
    private lateinit var btNextPage: Button
    // lateinit helps to aviod null

    private val questionArray: Array<String> = arrayOf(
        "IS 5 X 5 = 25 , TRUE OR FALSE",
        "IS 4 + 60 = 68 , TRUE OR FALSE",
        "IS 5 - 14 = -6 , TRUE OR FALSE",
        "IS 10 / 2 = 5 , TRUE OR FALSE",
        "HALF OF 17 A WHOLE NUMBER , TRUE OR FALSE"
    )
    private val answerArray: Array<String> =
        arrayOf("TRUE", "FALSE", "FALSE", "TRUE", "FALSE")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash_card_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvQuestion = findViewById(R.id.tvQuestion)
        btTrue = findViewById(R.id.bt_true)
        btFalse = findViewById(R.id.bt_false)
        btNextPage = findViewById(R.id.btNextPage)

        updateUi() // Initial display of the first question

        btTrue.setOnClickListener {
            handleAnswer("TRUE")
        }

        btFalse.setOnClickListener {
            handleAnswer("FALSE")
        }

        //used to end early or after you finish all the questions
        btNextPage.setOnClickListener {
            val intent = Intent(this, ResultSCreen::class.java)
            intent.putExtra("USER_SCORE", counter)
            intent.putExtra("TOTAL_QUESTIONS", questionArray.size)
            startActivity(intent)
            finish()
        }
    }

    private fun updateUi() {
        if (currentNumber < questionArray.size) {
            tvQuestion.text = questionArray[currentNumber]
            btTrue.isEnabled = true
            btFalse.isEnabled = true
            btNextPage.isEnabled = true// set to true so that the user is able to end test early can be modified if needed to make it not end early
        } else {
            tvQuestion.text = "Quiz Over! Click END SESSION for results."
            btTrue.isEnabled = false
            btFalse.isEnabled = false
            btNextPage.isEnabled = true
        }
    }

    private fun handleAnswer(userAnswer: String) {
        if (currentNumber < questionArray.size) {
            if (userAnswer.equals(answerArray[currentNumber], ignoreCase = true)) {
                counter++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect. Correct was: ${answerArray[currentNumber]}", Toast.LENGTH_SHORT).show()
            }
            currentNumber++
            updateUi() // helps to update the textview so it isnt empty or display end session
        }
    }
}
// https://www.youtube.com/watch?v=-PpSp5zF1fk (Arrays in Kotlin, Programming Guru, 2022)
// https://www.youtube.com/watch?v=e7WIPwRd2s8&list=PLlxmoA0rQ-Lw5k_QCqVl3rsoJOnb_00UV (Android Application Development using Kotlin Tutorials )




