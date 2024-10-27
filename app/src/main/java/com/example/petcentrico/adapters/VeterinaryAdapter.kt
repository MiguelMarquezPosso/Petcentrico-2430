package com.example.petcentrico.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petcentrico.R
import com.example.petcentrico.databinding.ItemVeterinaryBinding
import com.example.petcentrico.models.Veterinary

class VeterinaryAdapter(private val veterinaries: List<Veterinary>,
                        private val onVeterinarySelected: (Veterinary) -> Unit) :
    RecyclerView.Adapter<VeterinaryAdapter.VeterinaryViewHolder>() {

    // Definir el ViewHolder
    class VeterinaryViewHolder(private val binding: ItemVeterinaryBinding,
                               private val onItemSelected: (Veterinary) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bind(veterinary: Veterinary) {
            binding.apply {
                iconImageView.setImageResource( R.drawable.baseline_spa_24)
                nameTextView.text = veterinary.name
                descriptionTextView.text = veterinary.description
                selectButton.setOnClickListener {
                    onItemSelected(veterinary)
                }
            }
        }
    }

    // Crear el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VeterinaryViewHolder {
        val binding = ItemVeterinaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VeterinaryViewHolder(binding, onVeterinarySelected)
    }

    // Enlazar los datos con el ViewHolder
    override fun onBindViewHolder(holder: VeterinaryViewHolder, position: Int) {
        holder.bind(veterinaries[position])
    }

    // Obtener la cantidad de elementos en la lista
    override fun getItemCount() = veterinaries.size
}