package com.franciscojavier.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.franciscojavier.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.loginBtn.setOnClickListener{
            Toast.makeText(this@MainActivity,
                "Usuario: ${binding.userInput.text}, Contraseña: ${binding.pdwInput.text}",
                Toast.LENGTH_SHORT).show()
        }
    }


}