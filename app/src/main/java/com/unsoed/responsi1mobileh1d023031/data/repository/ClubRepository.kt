package com.unsoed.responsi1mobileh1d023031.data.repository

import com.unsoed.responsi1mobileh1d023031.data.model.ClubResponse
import com.unsoed.responsi1mobileh1d023031.data.network.RetrofitInstance // Wajib diimpor
import retrofit2.Response

class ClubRepository {
    private val apiService = RetrofitInstance.apiService

    // Fungsi ini wajib memiliki modifier 'suspend' karena ini adalah operasi jaringan
    suspend fun getClubData(): Response<ClubResponse> {
        // Panggil API service menggunakan Token dan ID Klub
        return apiService.getClubData(
            token = RetrofitInstance.API_TOKEN,
            clubId = RetrofitInstance.CLUB_ID
        )
    }
}