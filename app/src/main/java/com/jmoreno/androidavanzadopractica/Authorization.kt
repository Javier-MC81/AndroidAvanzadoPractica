package com.jmoreno.androidavanzadopractica

import retrofit2.http.Headers
import retrofit2.http.POST

data class Authorization(val credential:String) {
   val name = "Authorization: Basic $credential"

}