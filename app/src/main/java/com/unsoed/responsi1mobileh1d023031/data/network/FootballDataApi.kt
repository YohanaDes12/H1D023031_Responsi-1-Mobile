// File: data/network/FootballDataApi.kt
package com.unsoed.responsi1mobileh1d023031.data.network

import com.unsoed.responsi1mobileh1d023031.data.model.ClubResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header // Digunakan untuk Token
import retrofit2.http.Path // Digunakan untuk ID Klub

interface FootballDataApi {
    @GET("teams/{clubId}") // Endpoint API
    suspend fun getClubData(
        // Mengirimkan Token API di Header
        @Header("X-Auth-Token") token: String,
        // Mengambil ID Klub dari parameter fungsi
        @Path("clubId") clubId: Int
    ): Response<ClubResponse>
}