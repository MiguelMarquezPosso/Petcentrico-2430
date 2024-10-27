package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcentrico.adapters.PayAdapter
import com.example.petcentrico.databinding.ActivityPayServiceBinding
import com.example.petcentrico.models.Pay

class PayServiceActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPayServiceBinding
    private lateinit var payAdapter: PayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityPayServiceBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)

        // Configurar el RecyclerView
        setupRecyclerView()

        // Configurar el botón de retroceso
        binding.ivBack.setOnClickListener {
            val intent = Intent(applicationContext,ScheduleAppointmentActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón de retroceso a la pantalla principal
        binding.ivHome.setOnClickListener {
            val intent = Intent(applicationContext,ServicesActivity::class.java)
            startActivity(intent)
        }
    }

    // Configurar el RecyclerView
    private fun setupRecyclerView() {
        payAdapter = PayAdapter(
            payments = getPaymentsList(),
            onPaymentSelected = { payment ->
                // Aquí manejas la navegación
                navigateToPaymentConfirmation(payment)
            }
        )

        binding.rvServices.apply {
            layoutManager = LinearLayoutManager(this@PayServiceActivity)
            adapter = payAdapter
        }
    }

    private fun navigateToPaymentConfirmation(payment: Pay) {
        // Aquí manejas la navegación
        val intent = Intent(applicationContext, PaymentConfirmationActivity::class.java)
        startActivity(intent)
    }

    // Obtener la lista de metodos de pago
    private fun getPaymentsList(): List<Pay> {
        return listOf(
            Pay("Visa", "XXXX - 0001"),
            Pay("Mastercard", "XXXX - 0002"),
            Pay("New Bank", "XXXX - 0003"),
            Pay("Bancolombia", "XXXX - 0004"),
            Pay("BBVA", "XXXX - 0005")
        )
    }
}