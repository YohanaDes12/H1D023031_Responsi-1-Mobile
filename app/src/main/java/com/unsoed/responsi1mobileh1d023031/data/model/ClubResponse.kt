package com.unsoed.responsi1mobileh1d023031.data.model

// Pastikan Anda juga membuat data class HeadCoach.kt dan Squad.kt
data class ClubResponse(
    // Contoh properti dari API:
    val name: String,
    val crest: String?,
    val venue: String?,
    // Pastikan ini sesuai dengan nama file Anda:
    val coach: HeadCoach,
    val squad: List<Squad>
    // ... properti lainnya ...
)