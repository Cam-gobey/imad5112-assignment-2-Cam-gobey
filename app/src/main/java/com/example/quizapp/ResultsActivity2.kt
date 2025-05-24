package com.example.quizapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultsActivity2 : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results2)

        var score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions")!!
        val answers = intent.getBooleanArrayExtra("answers")!!

        findViewById<TextView>(R.id.scoreText).text = "Your Score: $score / 5"

            findViewById<TextView>(R.id.feedbackText).text

            findViewById<Button>(R.id.reviewButton).setOnClickListener {

                findViewById<Button>(R.id.exitButton).setOnClickListener {
                    finishAffinity()  // Exit the app
                }
            }
        }
    }