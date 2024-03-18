package com.mpd.pmdm.catapi.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mpd.pmdm.catapi.core.Cat
import com.mpd.pmdm.catapi.data.remote.CatApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatRepository(val api: CatApiClient) {
    private val catList = MutableLiveData<List<Cat>>()

    fun fetchCats(): MutableLiveData<List<Cat>> {
        val call = api.getCats(10)

        call.enqueue(object: Callback<List<Cat>>{
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                if(response.isSuccessful){
                    if(response.body() != null){
                        //Si la respuesta es HTTP OK, y tiene contenido, la almacenamos en la variable expuesta
                        catList.value = response.body()
                        Log.d("CatRepository","${response.body()}")
                    }
                }
            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                //throw t
                Log.e("CatRepository", "Error en la solicitud a la API", t)
            }

        })

        return catList

    }
}