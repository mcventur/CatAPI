package com.mpd.pmdm.catapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mpd.pmdm.catapi.data.remote.CatModel
import com.mpd.pmdm.catapi.databinding.FragmentCatItemBinding


class MyCatItemRecyclerViewAdapter(
    var catList: List<CatModel>
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
        holder.bindData(item)
    }

    override fun getItemCount(): Int = catList.size

    inner class ViewHolder(val binding: FragmentCatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(cat: CatModel) {
            binding.catId.text = cat.id
            binding.catImage.load(cat.imgUrl){

            }
        }
    }

    fun updateList(newList: List<CatModel>) {
        catList = newList
        notifyDataSetChanged()
    }

}