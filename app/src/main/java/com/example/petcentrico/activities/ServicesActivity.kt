package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcentrico.R
import com.example.petcentrico.models.Service
import com.example.petcentrico.adapters.ServicesAdapter
import com.example.petcentrico.databinding.ActivityServicesBinding

class ServicesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServicesBinding
    private lateinit var servicesAdapter: ServicesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityServicesBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)

        // Configurar el Spinner
        setupSpinner()
        // Configurar el RecyclerView
        setupRecyclerView()
        // Configurar la Bottom Navigation
        setupBottomNavigation()
        // Configurar el botón de búsqueda
        binding.etSearchServices.setOnClickListener {
            if (binding.etSearchServices.text.toString().isNotEmpty()) {
                val intent = Intent(applicationContext, VeterinarySearchActivity::class.java)
                startActivity(intent)
            }
        }
        // Configurar el botón de búsqueda con el teclado
        binding.etSearchServices.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (binding.etSearchServices.text.toString().isNotEmpty()) {
                    val intent = Intent(applicationContext, VeterinarySearchActivity::class.java)
                    startActivity(intent)
                }
                true // Indica que has manejado la acción
            } else {
                false
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_pets -> {
                    val intent = Intent(applicationContext, MyPetsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_preferences -> {
                    val intent = Intent(applicationContext, PreferencesActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_settings -> {
                    val intent = Intent(applicationContext, SettingsActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    // Configurar el Spinner
    private fun setupSpinner() {
        val pets = listOf("Matías", "Luna", "Max")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pets)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPets.adapter = adapter
    }

    // Configurar el RecyclerView
    private fun setupRecyclerView() {
        servicesAdapter = ServicesAdapter(
            services = getServicesList(),
            onServiceSelected = { service ->
                // Aquí manejas la navegación
                navigateToVeterinarySearch(service)
            }
        )

        binding.rvServices.apply {
            layoutManager = LinearLayoutManager(this@ServicesActivity)
            adapter = servicesAdapter
        }
    }

    private fun navigateToVeterinarySearch(service: Service) {
        val intent = Intent(applicationContext, VeterinarySearchActivity::class.java)
        startActivity(intent)
    }

    // Configurar la Bottom Navigation
    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_pets -> {
                    // Handle pets navigation
                    true
                }
                R.id.nav_preferences -> {
                    // Handle preferences navigation
                    true
                }
                R.id.nav_settings -> {
                    // Handle settings navigation
                    true
                }
                else -> false
            }
        }
    }

    // Obtener la lista de servicios
    private fun getServicesList(): List<Service> {
        return listOf(
            Service("Guardería", "Mascotas y patas", true),
            Service("Spa", "Love pets", true),
            Service("Spa", "Cuidado Mascotas", true),
            Service("Paseador", "Bruno Camina", false),
            Service("Veterinaria", "Paws Health", false)
        )
    }
}