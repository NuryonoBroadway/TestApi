package id.nuryono.testapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.nuryono.testapi.adapter.MyAdapter
import id.nuryono.testapi.databinding.ActivityMainBinding
import id.nuryono.testapi.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainBinding: ActivityMainBinding
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setupRecycleView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getData()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                myAdapter.setData(response.body()!!)
            } else {
                Toast.makeText(this,response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecycleView(){
        mainBinding.rvHeroesList.adapter = myAdapter
    }
}