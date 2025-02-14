package com.example.calculatorviewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorviewmodel.databinding.ActivityFotoBinding
import com.example.calculatorviewmodel.databinding.ItemRowBinding

class AdapterFoto(private val list: MutableList<foto>): RecyclerView.Adapter<AdapterFoto.listViewHolder>() {
    class listViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root) {
        val image = binding.imgPoto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
        var binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return listViewHolder(binding)
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val (poto) = list[position]
        holder.image.setImageResource(poto)
    }

    override fun getItemCount(): Int = list.size
}
data class foto(
    val poto: Int
)