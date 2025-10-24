package com.unsoed.responsi1mobileh1d023031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unsoed.responsi1mobileh1d023031.model.Player
import com.unsoed.responsi1mobileh1d023031.model.TeamResponse
import com.unsoed.responsi1mobileh1d023031.network.ApiClient
import com.unsoed.responsi1mobileh1d023031.adapter.PlayerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔹 Ambil data klub (contoh: 1. FC Köln → ID 81)
        getTeamData(81)
    }

    private fun getTeamData(id: Int) {
        ApiClient.instance.getTeam(id).enqueue(object : Callback<TeamResponse> {
            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    val team = response.body()
                    val tvTeamName = findViewById<TextView>(R.id.teamName)
                    val ivLogo = findViewById<ImageView>(R.id.teamLogo)

                    // 🔹 Set nama dan logo klub
                    tvTeamName.text = team?.name ?: "-"
                    Picasso.get()
                        .load(team?.crest)
                        .placeholder(R.drawable.ic_placeholder)
                        .error(R.drawable.ic_error)
                        .into(ivLogo)

                    // 🔹 Inisialisasi RecyclerView untuk daftar pemain
                    val recyclerView = findViewById<RecyclerView>(R.id.rvSquad)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                    // 🔹 Ambil dan konversi data pemain
                    val squadList = team?.squad?.map {
                        Player(
                            id = it.id,
                            name = it.name,
                            position = it.position ?: "Unknown",
                            dateOfBirth = it.dateOfBirth ?: "-",
                            nationality = it.nationality ?: "-"
                        )
                    } ?: emptyList()

                    recyclerView.adapter = PlayerAdapter(squadList)

                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Gagal memuat data: ${response.code()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Error: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}
