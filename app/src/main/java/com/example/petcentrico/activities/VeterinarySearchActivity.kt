package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcentrico.adapters.VeterinaryAdapter
import com.example.petcentrico.databinding.ActivityVeterinarySearchBinding
import com.example.petcentrico.models.Veterinary

class VeterinarySearchActivity: AppCompatActivity() {

    private lateinit var binding: ActivityVeterinarySearchBinding
    private lateinit var veterinaryAdapter: VeterinaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityVeterinarySearchBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)

        // Configurar el RecyclerView
        setupRecyclerView()
        // Configurar el botón de retroceso
        binding.ivBack.setOnClickListener {
            val intent = Intent(applicationContext,ServicesActivity::class.java)
            startActivity(intent)
        }
        // Configurar el botón de retroceso a la pantalla principal
        binding.ivHome.setOnClickListener {
            val intent = Intent(applicationContext,ServicesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        veterinaryAdapter = VeterinaryAdapter(
            veterinaries = getVeterinariesList(),
            onVeterinarySelected = { veterinary ->
                navigateToVeterinarySelection(veterinary)
            }
        )

        binding.rvVeterinaries.apply {
            layoutManager = LinearLayoutManager(this@VeterinarySearchActivity)
            adapter = veterinaryAdapter
        }
    }

    private fun navigateToVeterinarySelection(veterinary: Veterinary) {
        val intent = Intent(applicationContext, VeterinarySelectionActivity::class.java)
        startActivity(intent)
    }

    // Obtener la lista de veterinarias
    private fun getVeterinariesList(): List<Veterinary> {
        return listOf(
            Veterinary("Veterinaria", "Amor Animal"),
            Veterinary("Veterinaria", "Animal Feliz"),
            Veterinary("Veterinaria", "Amigos Peludos"),
            Veterinary("Veterinaria", "Cuidado Animal"),
            Veterinary("Veterinaria", "Cuidado Mascotas"),
            Veterinary("Veterinaria", "Firulays"),
            Veterinary("Veterinaria", "Huellitas Saludables"),
            Veterinary("Veterinaria", "Mascotas y patas"),
            Veterinary("Veterinaria", "Patas y Salud"),
            Veterinary("Veterinaria", "Patitas")
        )
    }
}