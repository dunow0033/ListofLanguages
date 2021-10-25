package com.example.listoflanguages.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listoflanguages.databinding.SingleItemBinding
import com.example.listoflanguages.models.Language

class RvAdapter (
    var languageList: List<Language>
) : RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(languageList[position]){
                binding.tvLangName.text = this.name
                binding.tvExp.text = this.exp
            }
        }
    }

    override fun getItemCount(): Int {
        return languageList.size
    }
}