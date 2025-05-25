package za.co.varsitycollege.st10479242.myproject2st

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score) // Load the score screen layout

        // Retrieve the score passed from QuizActivity (default to 0 if not found)
        val score = intent.getIntExtra("score", 0)

        // Link UI components from the layout file
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        // Display the final score out of 5
        scoreText.text = "Your Score: $score / 5"

        // Show feedback based on performance
        feedbackText.text = if (score >= 3) "Awesome job!" else "Keep practicing!"

        // Review button opens the ReviewActivity to show correct answers
        reviewButton.setOnClickListener {
            startActivity(Intent(this, ReviewActivity::class.java))
        }

        // Exit button closes all activities and exits the app
        exitButton.setOnClickListener {
            finishAffinity() // Finish this and all parent activities
        }
    }
}