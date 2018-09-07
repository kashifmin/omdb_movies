package me.kashifminhaj.omdbmovies.models

import com.google.gson.annotations.SerializedName

data class Response(
        @SerializedName("Search")
        val search: List<Movie>,
        val totalResults: Int,
        @SerializedName("Response")
        val success: Boolean
)