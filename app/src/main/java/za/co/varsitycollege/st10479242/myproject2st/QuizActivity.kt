package za.co.varsitycollege.st10479242.myproject2st

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class QuizActivity : AppCompatActivity() {

    // Array of quiz questions
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "World War II ended in 1942.",
        "The Great Wall of China is visible from space.",
        "The Roman Empire fell in 476 AD.",
        "The Cold War ended in 1991."
    )

    // Corresponding array of correct answers (True or False)
    private val answers = arrayOf(true, false, false, true, true)

    // Index to keep track of the current question
    private var currentIndex = 0

    // Variable to store the user's score
    private var score = 0

    // Declare UI components
    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz) // Set the layout for the quiz screen

        // Link UI components to their views
        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        // Display the first question
        showQuestion()

        // Handle clicks on the True button
        trueButton.setOnClickListener { checkAnswer(true) }

        // Handle clicks on the False button
        falseButton.setOnClickListener { checkAnswer(false) }

        // Handle clicks on the Next button
        nextButton.setOnClickListener {
            currentIndex++ // Move to the next question
            if (currentIndex < questions.size) {
                showQuestion() // Display the next question
            } else {
                // All questions answered, move to ScoreActivity
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score) // Pass the score
                startActivity(intent)
                finish() // Close this activity
            }
        }
    }

    // Function to display the current question
    private fun showQuestion() {
        questionText.text = questions[currentIndex] // Show the question text
        feedbackText.text = "" // Clear previous feedback

        // Re-enable buttons for the new question
        trueButton.isEnabled = true
        falseButton.isEnabled = true
    }

    // Function to check if the user's answer is correct
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            feedbackText.text = "Correct!"
            score++ // Increase score for correct answer
        } else {
            feedbackText.text = "Incorrect!"
        }

        // Disable answer buttons after answering
        trueButton.isEnabled = false
        falseButton.isEnabled = false
    }
}