package me.kashifminhaj.omdbmovies.models

import com.google.gson.annotations.SerializedName


data class Movie(
        @SerializedName("Title")
        val title: String,
        @SerializedName("Poster")
        val postUrl: String,
        @SerializedName("Year")
        val year: String
)