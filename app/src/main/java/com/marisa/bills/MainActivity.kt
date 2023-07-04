package com.marisa.bills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marisa.bills.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSignup.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
            validateSignup()
            clearErrors()
        }
    }

    fun validateSignup(){
        val name = binding.etName.text.toString()
        val phoneNumber  = binding.etPhone.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        var error = false


        if(name.isBlank()){
            binding.tilName.error  = "Enter your username"
            error = true
        }

        if(phoneNumber.isBlank()){
            binding.tilPhone.error = "Enter your phone number"
            error = true
        }

        if(email.isBlank()){
            binding.tilEmail.error = "Enter your email"
            error = true
        }

        if(password.isBlank()){
            binding.tilPassword.error = "enter your password"
            error = true
        }

    }

    fun clearErrors(){
        binding.tilName.error=null
        binding.tilPhone.error = null
        binding.tilEmail.error =null
        binding.tilPassword.error= null
    }
}