package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petcentrico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Configurar la actividad
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)

        // Configurar el botón de registro
        binding.signupButton.setOnClickListener {
            intent = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(intent)
        }
        // Configurar el botón de inicio de sesión
        binding.loginButton.setOnClickListener {
            intent = Intent(applicationContext, ServicesActivity::class.java)
            startActivity(intent)
        }
    }
}