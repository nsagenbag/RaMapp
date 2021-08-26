package com.e.ramapp.data.repos

import com.e.ramapp.data.dto.AllCharactersDto

interface RaMRepoInterface {

    suspend fun getAllCharacters(): AllCharactersDto

    suspend fun getAllEpisodes() : Any

    suspend fun getAllLocation() : Any
}