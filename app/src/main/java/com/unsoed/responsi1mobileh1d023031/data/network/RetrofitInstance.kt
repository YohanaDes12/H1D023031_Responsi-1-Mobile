// File: data/network/RetrofitInstance.kt
package com.unsoed.responsi1mobileh1d023031.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.football-data.org/v4/"

    // Token dan ID Klub harus disimpan di sini atau di Repository
    const val API_TOKEN = "731f617f415d412797bbb3f14dc14f4d"
    const val CLUB_ID = 81

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Objek API Service yang akan dipanggil di Repository
    val apiService: FootballDataApi by lazy {
        retrofit.create(FootballDataApi::class.java)
    }
}