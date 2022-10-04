package com.franciscojavier.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(val title: String, val urlImagen: String): Parcelable {
}