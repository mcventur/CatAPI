package com.mpd.pmdm.catapi.core

import android.net.Uri
import com.squareup.moshi.Json

/**
 * Clase que modela un Gato para usar como elemento del dominio de la aplicación
 */
data class Cat(
    val id: String,
    @Json(name = "url") var imgUrl: String
)
