package com.sanxynet.luxpm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.sanxynet.luxpm.databinding.ActivitySignUpBinding
import com.sanxynet.luxpm.utils.Validator

class SignUpActivity : Activity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.signUpButton.setOnClickListener {

            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (validate()) {
                Validator.isValidEmail(binding.editTextEmail, true)
                Validator.isValidPassword(binding.editTextPassword, true)

                if (Validator.isValidEmail(email, true)) {
                    if (Validator.isValidPassword(password, true)) {
                        Toast.makeText(
                            applicationContext,
                            "Email and password are good",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Toast.makeText(applicationContext, "Invalid password", Toast.LENGTH_SHORT)
                            .show()

                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Required email format is name@domain.com",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

        binding.loginTextView.setOnClickListener{
            Intent(applicationContext, LoginActivity::class.java).also {
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