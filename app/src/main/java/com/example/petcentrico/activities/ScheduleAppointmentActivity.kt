package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petcentrico.databinding.ActivityScheduleAppointmentBinding

class ScheduleAppointmentActivity: AppCompatActivity() {

    private lateinit var binding: ActivityScheduleAppointmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityScheduleAppointmentBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)

        // Configurar el botón de retroceso
        binding.ivBack.setOnClickListener {
            val intent = Intent(applicationContext,VeterinarySelectionActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón de retroceso a la pantalla principal
        binding.ivHome.setOnClickListener {
            val intent = Intent(applicationContext,ServicesActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón de pago
        binding.paymentButton.setOnClickListener {
            val intent = Intent(applicationContext,PayServiceActivity::class.java)
            startActivity(intent)
        }
    }
}