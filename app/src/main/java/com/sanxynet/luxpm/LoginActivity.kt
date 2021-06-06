package com.sanxynet.luxpm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.sanxynet.luxpm.databinding.ActivityLoginBinding


class LoginActivity : Activity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.loginButton.setOnClickListener {

            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (validate()) {
                if (email == "test@luxpmsoft.com" && password == "test1234!") {
                    Intent(applicationContext, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                } else {
                    Toast.makeText(applicationContext, "Invalid login details", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }

        binding.registerTextView.setOnClickListener {
            Intent(applicationContext, SignUpActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }


    private fun hasText(editText: EditText): Boolean {
        return hasText(editText, "Field Required")
    }

    private fun hasText(editText: EditText, error_message: String?): Boolean {
        val text = editText.text.toString().trim { it <= ' ' }
        editText.error = null

        /* length 0 means there is no text */
        if (text.isEmpty()) {
            editText.error = error_message
            return false
        }
        return true
    }

    private fun validate(): Boolean {
        var check = true
        if (!hasText(binding.editTextEmail)) check = false
        if (!hasText(binding.editTextPassword)) check = false
        return check
    }

}