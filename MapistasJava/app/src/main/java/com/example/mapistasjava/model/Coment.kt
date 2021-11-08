package com.example.mapistasjava.model

import java.util.*

class Coment(
    val id: Int,
    var authorId: Int,
    var authorDisplayName: String,
    var respuesta: ArrayList<Coment>,
    var reaccion: ArrayList<Reaction>
)