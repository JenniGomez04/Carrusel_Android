// Modelo de datos de imagen

package com.example.carruselandroid.model

import androidx.annotation.DrawableRes

// Representa una imagen con su recurso, título y descripción
data class ImageItem(
    // DrawableRes indica que el valor es un recurso de imagen
    @DrawableRes
    val imageRes: Int,
    val title: String,
    val description: String
)
