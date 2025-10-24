package com.unsoed.responsi1mobileh1d023031.data.model

import com.google.gson.annotations.SerializedName

data class Squad(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String, // Wajib: Goalkeeper, Defender, Midfielder, Forward
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("nationality")
    val nationality: String,
)