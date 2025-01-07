
package com.example.mathsp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var currentQuestionIndex = 0
    private val questions = listOf(
        "Solve: 5 + 3 × 2" to 11,
        "Solve: 12 ÷ 4 + 7" to 10,
        "Solve: 9 - 3 × 2" to 3,
        "Solve: (6 + 2) ÷ 2" to 4,
        "Solve: 8 × 2 - 5" to 11,
        "Solve: 15 ÷ 3 + 2" to 7,
        "Solve: 7 + 6 ÷ 2" to 10,
        "Solve: 10 × (2 + 1)" to 30,
        "Solve: 25 ÷ 5 + 5" to 10,
        "Solve: 3 × (4 + 5)" to 27
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val etAnswer = findViewById<EditText>(R.id.etAnswer)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvExplanation = findViewById<TextView>(R.id.tvExplanation)

        // Display the first question
        tvQuestion.text = questions[currentQuestionIndex].first

        btnSubmit.setOnClickListener {
            val userAnswer = etAnswer.text.toString().toIntOrNull()

            if (userAnswer == null) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            } else if (userAnswer == questions[currentQuestionIndex].second) {
                tvExplanation.text = "Correct! Explanation:\nFollow BODMAS to solve such problems."
                etAnswer.text.clear()

                currentQuestionIndex++

                if (currentQuestionIndex < questions.size) {
                    tvQuestion.text = questions[currentQuestionIndex].first
                    tvExplanation.text = "" // Clear the explanation for the next question
                } else {
                    tvQuestion.text = "Congratulations! You've completed all the puzzles!"
                    etAnswer.isEnabled = false
                    btnSubmit.isEnabled = false
                }
            } else {
                tvExplanation.text = "Incorrect! Try again.\nHint: Follow BODMAS."
            }
        }
    }
}
