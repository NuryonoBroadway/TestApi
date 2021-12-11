package id.nuryono.testapi.api

import id.nuryono.testapi.model.Heroes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/heroes")
    suspend fun getData() : Response<List<Heroes>>
}