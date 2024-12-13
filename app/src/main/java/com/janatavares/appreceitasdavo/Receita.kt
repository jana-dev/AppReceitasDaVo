package com.janatavares.appreceitasdavo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receita(
    val titulo: String,
    val tempo: String,
    val imagem: Int,
    val ingredientes: List<String>,
    val preparo: List<String>
) : Parcelable
