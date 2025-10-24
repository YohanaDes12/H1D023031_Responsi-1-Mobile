package com.unsoed.responsi1mobileh1d023031.viewmodel

import androidx.lifecycle.ViewModel // Wajib untuk mendefinisikan kelas ini sebagai ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope // Wajib untuk menjalankan Coroutines di latar belakang
import com.unsoed.responsi1mobileh1d023031.data.model.ClubResponse // Asumsi model data utama
import com.unsoed.responsi1mobileh1d023031.data.repository.ClubRepository // Wajib mengimpor Repository
import kotlinx.coroutines.launch // Wajib untuk Coroutines

class ClubViewModel : ViewModel() {

    // 1. Inisialisasi Repository
    private val repository = ClubRepository()

    // 2. Definisi LiveData untuk menampung data klub
    private val _clubData = MutableLiveData<ClubResponse?>()
    val clubData: LiveData<ClubResponse?> = _clubData

    // 3. Fungsi untuk mengambil data (Memperbaiki error "fungsi tidak ada")
    init {
        fetchClubData()
    }

    fun fetchClubData() {
        // Meluncurkan operasi jaringan di latar belakang (viewModelScope)
        viewModelScope.launch {
            try {
                // Panggil fungsi dari Repository
                val response = repository.getClubData()

                if (response.isSuccessful) {
                    _clubData.postValue(response.body())
                } else {
                    // Penanganan error jika kode status API bukan 200
                    _clubData.postValue(null)
                    // Anda bisa menambahkan LiveData khusus untuk pesan error
                }
            } catch (e: Exception) {
                // Penanganan error jaringan (misalnya, tidak ada koneksi)
                _clubData.postValue(null)
            }
        }
    }
}