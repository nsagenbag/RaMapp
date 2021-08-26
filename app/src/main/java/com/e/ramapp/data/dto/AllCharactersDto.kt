package com.e.ramapp.data.dto

import com.google.gson.annotations.SerializedName

data class AllCharactersDto(
    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: List<PayloadResults>
) {
    data class Info(
        @SerializedName("count")
        val count: Long?,

        @SerializedName("pages")
        val pages: Long?,

        @SerializedName("next")
        val next: String?,

        @SerializedName("prev")
        val prev: Any?
    )

    data class PayloadResults(
        @SerializedName("id")
        val id: Long?,

        @SerializedName("name")
        val name: String?,

        @SerializedName("status")
        val status: String?,

        @SerializedName("species")
        val species: String?,

        @SerializedName("type")
        val type: String?,

        @SerializedName("gender")
        val gender: String?,

        @SerializedName("origin")
        val origin: Location?,

        @SerializedName("location")
        val location: Location?,

        @SerializedName("image")
        val imageUrl: String?,

        @SerializedName("episode")
        val episodes: List<String>?,

        @SerializedName("url")
        val url: String?,

        @SerializedName("created")
        val created: String?,
    )

    data class Location(
        @SerializedName("name")
        val name: String?,

        @SerializedName("url")
        val url: String?
    )
}