package com.example.petcentrico.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petcentrico.R
import com.example.petcentrico.databinding.ItemPayBinding
import com.example.petcentrico.models.Pay

class PayAdapter(private val payments: List<Pay>,
                 private val onPaymentSelected: (Pay) -> Unit) :
    RecyclerView.Adapter<PayAdapter.PayViewHolder>(){

        // Definir el ViewHolder
    class PayViewHolder(private val binding: ItemPayBinding,
                        private val onPaymentSelected: (Pay) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pay: Pay) {
            binding.apply {
                iconImageView.setImageResource( R.drawable.baseline_payment_24)
                nameTextView.text = pay.name
                descriptionTextView.text = pay.description
                selectButton.setOnClickListener {
                    onPaymentSelected(pay)
                }
            }
        }
    }

    // Crear el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayViewHolder {
        val binding = ItemPayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PayViewHolder(binding, onPaymentSelected)
    }

    // Enlazar los datos con el ViewHolder
    override fun onBindViewHolder(holder: PayViewHolder, position: Int) {
        holder.bind(payments[position])
    }

    // Obtener la cantidad de elementos en la lista
    override fun getItemCount() = payments.size
}