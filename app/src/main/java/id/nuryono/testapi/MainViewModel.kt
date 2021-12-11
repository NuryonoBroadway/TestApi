package id.nuryono.testapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.nuryono.testapi.model.Heroes
import id.nuryono.testapi.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<List<Heroes>>> = MutableLiveData()

    fun getData() {
        viewModelScope.launch {
            val response = repository.getData()
            myResponse.value = response
        }
    }
}