package com.e.ramapp.data

import com.e.ramapp.data.dto.AllCharactersDto
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(): AllCharactersDto
}