package com.mpd.pmdm.catapi.data.remote

import com.squareup.moshi.Json

data class CatModel(val id: String, @Json(name = "url") var imgUrl: String)
