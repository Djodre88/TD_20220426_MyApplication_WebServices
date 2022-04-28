package com.example.td_20220426_myapplication_webservices.webservice

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "http://10.0.2.2/webservice/webservice.php/"

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            //            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
    }
    val instance: DaoArticle by lazy {
        retrofit.create(DaoArticle::class.java)
    }
}
