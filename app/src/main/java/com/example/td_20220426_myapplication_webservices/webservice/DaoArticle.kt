package com.example.td_20220426_myapplication_webservices.webservice

import com.example.td_20220426_myapplication_webservices.model.Article
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DaoArticle {
    @GET("articles")
    suspend fun getArticles(): List<Article>

    @POST("articles/")
    suspend fun createArticle(@Body article : Article): Article

}