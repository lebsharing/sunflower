package com.leb.sunflower.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leb.sunflower.data.model.Plant
import com.leb.sunflower.databinding.ListItemPlantBinding

class PlantAdapter:ListAdapter<Plant,RecyclerView.ViewHolder>(PlantDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemPlantBinding.inflate(LayoutInflater.from(parent.context),parent,false);
        return PlantViewHolder(binding);
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position);
        (holder as PlantViewHolder).bind(plant);
    }

    class PlantViewHolder(private val binding:ListItemPlantBinding): RecyclerView.ViewHolder(binding.root){

        init {

        }

        fun bind(item: Plant) {
            binding.apply {
                plant = item;
                executePendingBindings();
            }
        }
    }
}


private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>(){
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId;
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem;
    }
}