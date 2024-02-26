package com.mpd.pmdm.catapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mpd.pmdm.catapi.core.Cat
import com.mpd.pmdm.catapi.databinding.FragmentCatItemBinding


class MyCatItemRecyclerViewAdapter(
    var catList: List<Cat>
) : RecyclerView.Adapter<MyCatItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCatItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = catList[position]

    }

    override fun getItemCount(): Int = catList.size

    inner class ViewHolder(val binding: FragmentCatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(cat: Cat) {
            binding.catId.text = cat.id
            //TODO: Falta mostrar la imagen
        }
    }


}