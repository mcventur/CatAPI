package com.mpd.pmdm.catapi.network

import com.mpd.pmdm.catapi.data.remote.CatModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * En esta interface definimos los distintos request a la api con la anotación del método (GET,POST, PUT, etc... ) correspondiente.
 *
 * Además, podemos parametrizar ciertos datos de la consulta y de la url a partir de parámetros
 *
 * Nótese que la respuesta se envuelve en un objeto Call de Retrofit, que nos permite manejar la solicitud de forma asíncrona
 *
 * @see <a href="https://square.github.io/retrofit/#api-declaration">Retrofit API</a>
 * @see <a href="https://square.github.io/retrofit/2.x/retrofit/retrofit2/Call.html">Call</a>
 */

interface ApiService {
    @GET("images/search")
    fun getCatImages(@Query("limit") limit: Int): Call<List<CatModel>>
}