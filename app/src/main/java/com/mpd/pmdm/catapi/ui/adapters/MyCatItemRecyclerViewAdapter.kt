package com.mpd.pmdm.catapi.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mpd.pmdm.catapi.R
import com.mpd.pmdm.catapi.core.Cat
import com.mpd.pmdm.catapi.databinding.FragmentCatItemBinding


class MyCatItemRecyclerViewAdapter(
    private var catList: List<Cat>
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
        fun bindData(cat: Cat) {
            val aleatorio = (1..10).random()
            //ESTO PARA PROBAR LA IMAGEN DE ERROR
//            if(aleatorio > 7){
//                cat.imgUrl += "roto"
//            }
            binding.catId.text = cat.id
            binding.catImage.load(cat.imgUrl){
                placeholder(R.drawable._00w)
                error(R.drawable.baseline_block_24)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Cat>){
        catList = newList
        notifyDataSetChanged()
    }


}