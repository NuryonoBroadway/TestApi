package id.nuryono.testapi.api

import id.nuryono.testapi.util.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}