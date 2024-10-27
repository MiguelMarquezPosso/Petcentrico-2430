package com.example.petcentrico.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petcentrico.R
import com.example.petcentrico.databinding.ItemPetBinding
import com.example.petcentrico.models.Pet

class PetAdapter(private val pets: List<Pet>,
                 private val onPetSelected: (Pet) -> Unit) :
    RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    // Definir el ViewHolder
    class PetViewHolder(private val binding: ItemPetBinding,
                        private val onPetSelected: (Pet) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pet: Pet) {
            binding.apply {
                iconImageView.setImageResource( R.drawable.pet)
                nameTextView.text = pet.name
                descriptionTextView.text = pet.description
                selectButton.setOnClickListener {
                    onPetSelected(pet)
                }
            }
        }
    }

    // Crear el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val binding = ItemPetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PetViewHolder(binding, onPetSelected)
    }

    // Enlazar los datos con el ViewHolder
    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bind(pets[position])
    }

    // Obtener la cantidad de elementos en la lista
    override fun getItemCount() = pets.size
}