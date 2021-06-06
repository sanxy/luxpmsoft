package com.sanxynet.luxpm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.sanxynet.luxpm.databinding.ActivityWelcomeBinding


class WelcomeActivity : Activity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.signUp.setOnClickListener {
            Intent(applicationContext, SignUpActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.login.setOnClickListener {
            Intent(applicationContext, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }


}