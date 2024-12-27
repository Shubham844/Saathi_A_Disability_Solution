package com.example.myapplication.saathi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var edit_text1:EditText
    lateinit var edit_text2: EditText
    lateinit var edit_text3: EditText
    lateinit var button_one : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edit_text1 = findViewById(R.id.edit_text1)
        edit_text2 = findViewById(R.id.edit_text2)
        edit_text3 = findViewById(R.id.edit_text3)
        val editText = findViewById<EditText>(R.id.edit_text3)
        val maxLength = 10
        val filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        editText.filters = filters

        button_one = findViewById(R.id.button_one)

        button_one.setOnClickListener {

            val firstName = edit_text1.text.toString()
            val lastName = edit_text2.text.toString()
            val phoneNumber = edit_text3.text.toString()

            if (isValidInput(firstName, lastName, phoneNumber)) {
                // If input is valid, proceed to the next activity
                val intent = Intent(this, OtpActivity::class.java)
                startActivity(intent)
            } else {
                // Display an error message or handle invalid input
                // For example, you can show a Toast message
                Toast.makeText(
                    this,
                    "Invalid input. Please check your entries.",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

    private fun isValidInput(firstName: String, lastName: String, phoneNumber: String): Boolean {
        if (firstName.isNotEmpty() && lastName.isNotEmpty() && phoneNumber.isNotEmpty()) {

            if (phoneNumber.length >= 10) {
                return true
            } else {
                Toast.makeText(this, "Invalid Number: Please enter at least 10 digits.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Invalid input. Please check your entries.", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}