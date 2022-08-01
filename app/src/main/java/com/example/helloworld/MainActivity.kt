package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button= findViewById<Button>(R.id.button)
        button.setOnClickListener(){
            Log.v("Hello Worlld","Button clicked")
            Toast.makeText(this, "This button was clicked.", Toast.LENGTH_SHORT).show()
        }

        val nextButton=findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener(){
            Toast.makeText(this, "Next page.", Toast.LENGTH_SHORT).show()
            openNextScreen()
        }
    }
     fun openNextScreen(){
         val intent = Intent(this, SecondActivity::class.java)
         startActivity(intent)
     }

}