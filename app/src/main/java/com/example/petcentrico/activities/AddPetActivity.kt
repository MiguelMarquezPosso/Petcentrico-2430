package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petcentrico.databinding.ActivityAddPetBinding

class AddPetActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAddPetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityAddPetBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)
        // Configurar el botón de retroceso a la pantalla principal
        binding.ivHome.setOnClickListener {
            val intent = Intent(applicationContext,ServicesActivity::class.java)
            startActivity(intent)
        }

        binding.ivBack.setOnClickListener {
            val intent = Intent(applicationContext,ServicesActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón de agregar mascota
        binding.btnAdd.setOnClickListener {
            val intent = Intent(applicationContext, MyPetsActivity::class.java)
            startActivity(intent)
        }
    }
}