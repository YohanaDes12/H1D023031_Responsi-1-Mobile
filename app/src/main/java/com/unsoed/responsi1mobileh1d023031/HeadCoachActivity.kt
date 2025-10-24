package com.unsoed.responsi1mobileh1d023031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.unsoed.responsi1mobileh1d023031.model.ClubResponse
import com.unsoed.responsi1mobileh1d023031.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeadCoachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_head_coach)

        getCoachData(81) // ID klub Arsenal FC (sesuai contoh awal)
    }

    private fun getCoachData(id: Int) {
        ApiClient.instance.getTeam(id).enqueue(object : Callback<TeamResponse> {
            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    val coach = response.body()?.coach

                    // Ambil TextView dari layout
                    val tvCoachName = findViewById<TextView>(R.id.tvHeadCoachName)
                    val tvCoachDob = findViewById<TextView>(R.id.tvHeadCoachDateOfBirth)
                    val tvCoachNationality = findViewById<TextView>(R.id.tvHeadCoachNationality)

                    // Set teks sesuai data API atau tampilkan "-"
                    tvCoachName.text = coach?.name ?: "-"
                    tvCoachDob.text = coach?.dateOfBirth ?: "-"
                    tvCoachNationality.text = coach?.nationality ?: "-"
                } else {
                    Toast.makeText(this@HeadCoachActivity, "Gagal ambil data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Toast.makeText(this@HeadCoachActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
