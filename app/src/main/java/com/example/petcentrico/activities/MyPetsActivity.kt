package com.example.petcentrico.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcentrico.adapters.PetAdapter
import com.example.petcentrico.databinding.ActivityMyPetsBinding
import com.example.petcentrico.models.Pet

class MyPetsActivity:AppCompatActivity() {
    private lateinit var binding:ActivityMyPetsBinding
    private lateinit var petAdapter: PetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar la vista utilizando ViewBinding
        binding = ActivityMyPetsBinding.inflate(layoutInflater)
        // Establecer el contenido de la vista
        setContentView(binding.root)
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

        // Configurar el botón de agregar mascota
        binding.addPet.setOnClickListener {
            val intent = Intent(applicationContext, AddPetActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        petAdapter = PetAdapter(
            pets = getPetsList(),
            onPetSelected = { pet ->
                navigateToPetSelection(pet)
            }
        )

        binding.rvPets.apply {
            layoutManager = LinearLayoutManager(this@MyPetsActivity)
            adapter = petAdapter
        }
    }

    private fun navigateToPetSelection(pet: Pet) {
        val intent = Intent(applicationContext, ServicesActivity::class.java)
        startActivity(intent)
    }

    // Obtener la lista de veterinarias
    private fun getPetsList(): List<Pet> {
        return listOf(
            Pet("Matías", "Pinscher"),
            Pet("Luna", "Akita Inu"),
            Pet("Max", "Pug")
        )
    }
}