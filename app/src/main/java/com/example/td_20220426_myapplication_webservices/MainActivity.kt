package com.example.td_20220426_myapplication_webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.td_20220426_myapplication_webservices.databinding.ActivityMainBinding
import com.example.td_20220426_myapplication_webservices.model.Article
import com.example.td_20220426_myapplication_webservices.webservice.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.allArticles.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                var bool = true
                binding.progressBar.visibility = VISIBLE
                withContext(Dispatchers.IO) {
                    Thread.sleep(3000)
                    val articles = RetrofitInstance.instance.getArticle()
                    Log.d("articles", articles.toString())
                        bool = false
                }
                if (!bool) binding.progressBar.visibility = GONE
            }
        }

        binding.insertArticle.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val article = RetrofitInstance.instance.createArticle(Article(0, 1, "Retrofit", "Insert"))
                Log.d("articles", article.toString())
            }
        }

        binding.updateArticle.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val article = RetrofitInstance.instance.updateArticle(23, Article(23,1, "Retrofit", "Update1"))
                Log.d("articles", article.toString())
            }
        }

        binding.deleteArticle.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                RetrofitInstance.instance.deleteArticle(23)
                Log.d("articles", "Deleted article")
            }
        }
    }
}
