package com.example.petcentrico.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petcentrico.R

import com.example.petcentrico.databinding.ItemServiceBinding
import com.example.petcentrico.models.Service

class ServicesAdapter(private val services: List<Service>,
                      private val onServiceSelected: (Service) -> Unit) :
    RecyclerView.Adapter<ServicesAdapter.ServiceViewHolder>() {

        // Definir el ViewHolder
    class ServiceViewHolder(private val binding: ItemServiceBinding,
                            private val onServiceSelected: (Service) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bind(service: Service) {
            binding.apply {
                tvServiceName.text = service.name
                tvServiceDescription.text = service.description
                ivStar.setImageResource(if (service.isStarred) R.drawable.baseline_star_24 else R.drawable.baseline_star_border_24)
                btnSelect.setOnClickListener {
                    onServiceSelected(service)
                }
            }
        }
    }

    // Crear el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val binding = ItemServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceViewHolder(binding, onServiceSelected)
    }

    // Enlazar los datos con el ViewHolder
    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(services[position])
    }

    // Obtener la cantidad de elementos en la lista
    override fun getItemCount() = services.size
}