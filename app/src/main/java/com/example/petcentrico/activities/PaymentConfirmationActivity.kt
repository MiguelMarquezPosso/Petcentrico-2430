package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petcentrico.databinding.ActivityPaymentConfirmationBinding

class PaymentConfirmationActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPaymentConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityPaymentConfirmationBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)

        // Configurar el botón de retroceso a la pantalla principal
        binding.backButton.setOnClickListener {
            intent = Intent(applicationContext, ServicesActivity::class.java)
            startActivity(intent)
        }
    }
}