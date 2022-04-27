package com.example.td_20220426_myapplication_webservices.webservice

import com.example.td_20220426_myapplication_webservices.model.Article
import retrofit2.http.*

interface DaoArticle {
    @GET("articles")
    suspend fun getArticle(): List<Article>

    @POST("articles")
    suspend fun createArticle(@Body article : Article): Article

    @PUT("article/{id}")
    suspend fun updateArticle(@Path("id") articleId: Int, @Body article: Article): Article


    @DELETE("article/{id}")
    suspend fun deleteArticle(@Path("id") articleId: Int)

}