package com.mpd.pmdm.catapi.data.remote

import com.mpd.pmdm.catapi.core.Cat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiClient {
    @GET("images/search")
    fun getCats(@Query("limit") limit: Int): Call<List<Cat>>
    //La función anterior con laS ANOTACIONES equivale a una consulta
    //Url_base + images/search?limit=[VALOR_PARAMETRO_LIMIT]
}