package com.mpd.pmdm.catapi.core

import android.app.Application
import com.mpd.pmdm.catapi.data.CatRepository
import com.mpd.pmdm.catapi.data.remote.CatApiClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class CatApp: Application() {

    lateinit var catRepository: CatRepository

    override fun onCreate() {
        super.onCreate()
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val api: CatApiClient = retrofit.create(CatApiClient::class.java)

        catRepository = CatRepository(api)
    }


}