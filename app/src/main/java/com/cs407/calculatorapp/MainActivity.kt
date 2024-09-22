package com.cs407.calculatorapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addition = findViewById<Button>(R.id.addition)
        val subtraction = findViewById<Button>(R.id.subtraction)
        val multiplication = findViewById<Button>(R.id.multiplication)
        val division = findViewById<Button>(R.id.division)

        var firstNumberEditText = findViewById<EditText>(R.id.firstNumber)
        var secondNumberEditText = findViewById<EditText>(R.id.secondNumber)



        addition.setOnClickListener{
            val firstNumberText = firstNumberEditText.text.toString()
            val secondNumberText = secondNumberEditText.text.toString()
            val firstInput = firstNumberText.toIntOrNull()
            val secondInput = secondNumberText.toIntOrNull()
            var result = 0

            if (firstInput != null && secondInput != null) {
                result = firstInput + secondInput
                val intent = Intent(this, CalculatorResult::class.java)
                intent.putExtra("EXTRA_MESSAGE", result.toString())  // Pass result as a String
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
        subtraction.setOnClickListener{
            val firstNumberText = firstNumberEditText.text.toString()
            val secondNumberText = secondNumberEditText.text.toString()
            val firstInput = firstNumberText.toIntOrNull()
            val secondInput = secondNumberText.toIntOrNull()
            var result = 0

            if (firstInput != null && secondInput != null) {
                result = firstInput - secondInput
                val intent = Intent(this, CalculatorResult::class.java)
                intent.putExtra("EXTRA_MESSAGE", result.toString())  // Pass result as a String
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
        multiplication.setOnClickListener{
            val firstNumberText = firstNumberEditText.text.toString()
            val secondNumberText = secondNumberEditText.text.toString()
            val firstInput = firstNumberText.toIntOrNull()
            val secondInput = secondNumberText.toIntOrNull()
            var result = 0

            if (firstInput != null && secondInput != null) {
                result = firstInput * secondInput
                val intent = Intent(this, CalculatorResult::class.java)
                intent.putExtra("EXTRA_MESSAGE", result.toString())  // Pass result as a String
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
        division.setOnClickListener{
            val firstNumberText = firstNumberEditText.text.toString()
            val secondNumberText = secondNumberEditText.text.toString()
            val firstInput = firstNumberText.toIntOrNull()
            val secondInput = secondNumberText.toIntOrNull()
            var result = 0

            if (firstInput != null && secondInput != null) {
                if(secondInput != 0){
                    result = firstInput / secondInput
                    val intent = Intent(this, CalculatorResult::class.java)
                    intent.putExtra("EXTRA_MESSAGE", result.toString())  // Pass result as a String
                    startActivity(intent)
            } else {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                }
        } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }

    }
}