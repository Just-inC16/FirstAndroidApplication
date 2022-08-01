package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class InvalidSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invalid_second)

        val homeButton=findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener(){
            Toast.makeText(this, "Thank you for playing", Toast.LENGTH_SHORT).show()
            openNextScreen()
        }
    }
    fun openNextScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}