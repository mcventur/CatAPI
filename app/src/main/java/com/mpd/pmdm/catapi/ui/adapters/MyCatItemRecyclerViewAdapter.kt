package com.mpd.pmdm.catapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mpd.pmdm.catapi.core.Cat
import com.mpd.pmdm.catapi.databinding.FragmentCatItemBinding


class MyCatItemRecyclerViewAdapter() : ListAdapter<Cat, MyCatItemRecyclerViewAdapter.ViewHolder>(DiffCallback) {

    object DiffCallback: DiffUtil.ItemCallback<Cat>(){
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCatItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindData(item)
    }

    inner class ViewHolder(val binding: FragmentCatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(cat: Cat) {
            binding.catId.text = cat.id
            //TODO: Falta mostrar la imagen
        }
    }


}