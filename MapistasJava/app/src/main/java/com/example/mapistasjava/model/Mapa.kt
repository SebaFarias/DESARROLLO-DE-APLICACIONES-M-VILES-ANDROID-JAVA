package com.example.mapistasjava.model

import java.util.*

class Mapa(
    var id: Int,
    var authorId: Int,
    var nombre: String,
    var authorDisplayName: String,
    var descripción: String,
    var puntos: ArrayList<Spot>,
    var comentarios: ArrayList<Coment>,
    var reacciones: ArrayList<Reaction>
) {
    fun agregarSpot(newPunto: Spot): Boolean {
        return try {
            puntos.add(newPunto)
            true
        } catch (ex: Exception) {
            false
        }
    }
}