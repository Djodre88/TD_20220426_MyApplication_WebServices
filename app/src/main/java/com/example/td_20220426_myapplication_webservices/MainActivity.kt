package com.example.td_20220426_myapplication_webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.td_20220426_myapplication_webservices.databinding.ActivityMainBinding
import com.example.td_20220426_myapplication_webservices.webservice.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.allArticles.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                val articles = RetrofitInstance.instance.getArticles()
                Log.d("articles", articles.toString())
            }
        }
    }
}
