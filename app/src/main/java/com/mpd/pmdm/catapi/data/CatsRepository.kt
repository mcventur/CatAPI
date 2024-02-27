package com.mpd.pmdm.catapi.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mpd.pmdm.catapi.data.remote.CatModel
import com.mpd.pmdm.catapi.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatsRepository(val api: ApiService) {

    fun fetchCats(): LiveData<List<CatModel>> {
        val catList = MutableLiveData<List<CatModel>>()
        val call = api.getCatImages(10)

        call.enqueue(object : Callback<List<CatModel>> {
            override fun onResponse(call: Call<List<CatModel>>, response: Response<List<CatModel>>) {
                if (response.isSuccessful) {
                    catList.value = response.body() ?: emptyList()
                }
            }

            override fun onFailure(call: Call<List<CatModel>>, t: Throwable) {
                Log.d("CatsRepository", "Error al recuperar gatos desde la API", t)
                throw t
            }

        })

        //Aunque lo devuelto es un MutableLiveData, se guarda en una referencia de LiveData inmutable por el tipo de retorno de la función
        return catList
    }
}