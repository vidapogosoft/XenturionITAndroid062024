package com.android.apirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.android.apirest.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import android.widget.Button
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    */

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svDogs.setOnQueryTextListener(this)

        initRecyclerView()

        val BtnPost = findViewById<Button>(R.id.BtnPost)

        BtnPost.setOnClickListener{
            PostData();
        }

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.lowercase())
        }
        return true
    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun searchByName(query:String){

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")//parametro del url para el get
            val resultado = call.body() //response
            runOnUiThread {
                if(call.isSuccessful){
                    val images = resultado?.images ?: emptyList()//Lista de imagenes
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }

                hideKeyboard()
            }
        }

    }

    private fun PostData(){

        val datapost = DogInfo(  userId = 1,
            title = "vpr - husky",
            body = "post json")

        CoroutineScope(Dispatchers.IO).launch {
            val call = postRetrofit().create(APIService::class.java).addResource(datapost)
            runOnUiThread {
                if(call != null){
                    showOn(call.request().toString())
                }else{
                    showError()
                }
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun postRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    private fun showOn(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }
}