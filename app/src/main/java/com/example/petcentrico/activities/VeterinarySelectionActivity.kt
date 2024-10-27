package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petcentrico.databinding.ActivityVeterinarySelectionBinding

class VeterinarySelectionActivity: AppCompatActivity() {
    private lateinit var binding: ActivityVeterinarySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityVeterinarySelectionBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)

        // Configurar el botón de retroceso
        binding.ivBack.setOnClickListener {
            val intent = Intent(applicationContext,VeterinarySearchActivity::class.java)
            startActivity(intent)
        }
        // Configurar el botón de retroceso a la pantalla principal
        binding.ivHome.setOnClickListener {
            val intent = Intent(applicationContext,ServicesActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón de disponibilidad
        binding.availabilityButton.setOnClickListener {
            val intent = Intent(applicationContext,ScheduleAppointmentActivity::class.java)
            startActivity(intent)
        }
    }
}