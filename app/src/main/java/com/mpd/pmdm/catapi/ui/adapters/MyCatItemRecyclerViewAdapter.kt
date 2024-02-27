package com.mpd.pmdm.catapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import com.mpd.pmdm.catapi.R
import com.mpd.pmdm.catapi.data.remote.CatModel
import com.mpd.pmdm.catapi.databinding.FragmentCatItemBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


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
        pruebaError(position, item)
        holder.bindData(item)
    }

    /**
     * Genera un error en la url de una de las imágenes.
     * Para ver el resultado
     */
    private fun pruebaError(position: Int, item: CatModel) {
        val posError = (1..10).random()
        if(position == posError){
            item.imgUrl += "roto"
        }
    }

    override fun getItemCount(): Int = catList.size

    inner class ViewHolder(val binding: FragmentCatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(cat: CatModel) {
            binding.catId.text = cat.id
            binding.catImage.load(cat.imgUrl){
                crossfade(true)
                placeholder(R.drawable._00w)
                error(R.drawable.rounded_error_24)
            }
        }
    }

    fun updateList(newList: List<CatModel>) {
        catList = newList
        notifyDataSetChanged()
    }

}