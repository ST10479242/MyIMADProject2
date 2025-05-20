package za.co.varsitycollege.st10479242.myproject2st

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class ReviewActivity : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "World War II ended in 1942.",
        "The Great Wall of China is visible from space.",
        "The Roman Empire fell in 476 AD.",
        "The Cold War ended in 1991."
    )
    private val answers = arrayOf(true, false, false, true, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val reviewTextView = findViewById<TextView>(R.id.reviewText)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val builder = StringBuilder()
        for (i in questions.indices) {
            builder.append("${i + 1}. ${questions[i]}\nCorrect Answer: ${answers[i]}\n\n")
        }
        reviewTextView.text = builder.toString()
        exitButton.setOnClickListener {
            finish()


        }
    }
}