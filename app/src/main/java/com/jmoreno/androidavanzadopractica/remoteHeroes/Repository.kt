package com.jmoreno.androidavanzadopractica.remoteHeroes

import com.jmoreno.androidavanzadopractica.ui.model.Superhero

interface Repository {
    suspend fun getHeros(token: String?): List<Superhero>
}