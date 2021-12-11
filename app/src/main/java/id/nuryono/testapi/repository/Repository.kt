package id.nuryono.testapi.repository

import id.nuryono.testapi.api.RetrofitInstance
import id.nuryono.testapi.model.Heroes
import retrofit2.Call
import retrofit2.Response

class Repository {
    suspend fun getData() : Response<List<Heroes>> {
        return RetrofitInstance.api.getData()
    }
}