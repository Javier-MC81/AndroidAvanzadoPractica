package com.jmoreno.androidavanzadopractica

interface Repository {
    suspend fun getToken(credential: String): String
}
