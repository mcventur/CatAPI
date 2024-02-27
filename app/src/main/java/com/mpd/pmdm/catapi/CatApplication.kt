package com.mpd.pmdm.catapi

import android.app.Application
import com.mpd.pmdm.catapi.data.CatsRepository
import com.mpd.pmdm.catapi.network.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CatApplication : Application() {
    private val baseUrl = "https://api.thecatapi.com/v1/"

    lateinit var catsRepository: CatsRepository

    override fun onCreate() {
        super.onCreate()

        //Creamos la instancia de retrofit, y con ella, el servicio
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())//para que funcionen  las anotaciones de Moshi con Kotlin
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val apiService: ApiService = retrofit.create(ApiService::class.java)

        catsRepository = CatsRepository(apiService)
    }
}