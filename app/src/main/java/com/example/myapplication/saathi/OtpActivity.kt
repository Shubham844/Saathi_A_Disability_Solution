package com.example.myapplication.saathi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class OtpActivity : AppCompatActivity() {

    lateinit var edit_text4: EditText
    lateinit var edit_text5: EditText
    lateinit var edit_text6: EditText
    lateinit var edit_text7: EditText
    lateinit var edit_text8: EditText
    lateinit var edit_text9: EditText
    lateinit var button_two: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        edit_text4 = findViewById(R.id.edit_text4)
        edit_text5 = findViewById(R.id.edit_text5)
        edit_text6 = findViewById(R.id.edit_text6)
        edit_text7 = findViewById(R.id.edit_text7)
        edit_text8 = findViewById(R.id.edit_text8)
        edit_text9 = findViewById(R.id.edit_text9)
        button_two = findViewById(R.id.button_two)

        setupOtpInputs()

        button_two.setOnClickListener {
            // Directly open FirebaseActivity without checking OTP
            val intent = Intent(this, FirebaseActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupOtpInputs() {
        edit_text4.addTextChangedListener(OtpTextWatcher(edit_text4, edit_text5))
        edit_text5.addTextChangedListener(OtpTextWatcher(edit_text5, edit_text6, edit_text4))
        edit_text6.addTextChangedListener(OtpTextWatcher(edit_text6, edit_text7, edit_text5))
        edit_text7.addTextChangedListener(OtpTextWatcher(edit_text7, edit_text8, edit_text6))
        edit_text8.addTextChangedListener(OtpTextWatcher(edit_text8, edit_text9, edit_text7))
        edit_text9.addTextChangedListener(OtpTextWatcher(edit_text9, null, edit_text8))

        setOnBackPressListener(edit_text5, edit_text4)
        setOnBackPressListener(edit_text6, edit_text5)
        setOnBackPressListener(edit_text7, edit_text6)
        setOnBackPressListener(edit_text8, edit_text7)
        setOnBackPressListener(edit_text9, edit_text8)
    }

    private fun setOnBackPressListener(currentEditText: EditText, previousEditText: EditText?) {
        currentEditText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                if (currentEditText.text.isEmpty() && previousEditText != null) {
                    previousEditText.requestFocus()
                }
            }
            false
        })
    }

    inner class OtpTextWatcher(
        private val currentEditText: EditText,
        private val nextEditText: EditText?,
        private val previousEditText: EditText? = null
    ) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (s?.length == 1) {
                nextEditText?.requestFocus()
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            if (count == 1 && after == 0 && s.isNullOrEmpty()) {
                previousEditText?.requestFocus()
            }
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }
}