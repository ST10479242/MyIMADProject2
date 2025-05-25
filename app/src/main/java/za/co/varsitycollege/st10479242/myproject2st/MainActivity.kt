package za.co.varsitycollege.st10479242.myproject2st
//ST10479242

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Start button from the layout
        val startButton = findViewById<Button>(R.id.startButton)

        // Set a click listener to launch the QuizActivity when the button is clicked
        startButton.setOnClickListener {
            // Log the button click (useful for debugging)
            Log.d("MainActivity", "Start button clicked, launching QuizActivity")

            // Start the quiz screen
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}