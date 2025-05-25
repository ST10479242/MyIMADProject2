package za.co.varsitycollege.st10479242.myproject2st

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class ReviewActivity : AppCompatActivity() {

    // Array of quiz questions
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "World War II ended in 1942.",
        "The Great Wall of China is visible from space.",
        "The Roman Empire fell in 476 AD.",
        "The Cold War ended in 1991."
    )

    // Corresponding array of correct answers
    private val answers = arrayOf(true, false, false, true, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        // Get references to the TextView and Button from the layout
        val reviewTextView = findViewById<TextView>(R.id.reviewText)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val builder = StringBuilder()

        // Loop through each question and its answer to build the review text
        for (i in questions.indices) {
            builder.append("${i + 1}. ${questions[i]}\nCorrect Answer: ${answers[i]}\n\n")
        }

        // Display the constructed review text in the TextView
        reviewTextView.text = builder.toString()

        // When the exit button is clicked, close this activity and return to the previous screen
        exitButton.setOnClickListener {
            finish()
        }
    }
}
