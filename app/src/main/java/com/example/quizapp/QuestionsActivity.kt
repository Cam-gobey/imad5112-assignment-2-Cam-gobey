package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        val questions = arrayOf(
            "The Great Fire of London occurred in 1665",
            "The Ancient Library of Alexandria was destroyed by the Romans",
            "Marie Antoinette was the Queen of France during the French Revolution",
            "The battle of Gettysburg was a decisive Union victory in thr American Civil War",
            "The Soweto Uprising took place in 1976 as a protest against Afrikaans language instruction"
        )

        val answers = booleanArrayOf(
            false,
            false,
            true,
            true,
            true
        )

        var currentIndex = 0
        var score = 0
        val wrongQuestions = ArrayList<String>()

        fun updateQuestion() {
            if (currentIndex < questions.size) {
                val questionText: TextView = findViewById(R.id.textView2)
                questionText.text = questions[currentIndex]
            }
        }

        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = answers[currentIndex]
            val currentQuestions = questions[currentIndex]

            if (userAnswer == correctAnswer) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                wrongQuestions.add(currentQuestions)
                score++
            } else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                wrongQuestions.add(currentQuestions)
            }

            currentIndex++
            if (currentIndex < questions.size) {
                updateQuestion()
            } else {
                val intent = Intent(this, ResultsActivity2::class.java)
                intent.putExtra("score", score)
                intent.putStringArrayListExtra("wrongList", wrongQuestions)
                startActivity(intent)
                finish()
            }
        }



        val trueButton: Button = findViewById(R.id.button2)
        val falseButton: Button = findViewById(R.id.button3)

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        updateQuestion()
            }
        }
    




