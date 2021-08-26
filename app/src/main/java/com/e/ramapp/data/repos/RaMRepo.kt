package com.e.ramapp.data.repos

import com.e.ramapp.data.NetworkService
import com.e.ramapp.data.dto.AllCharactersDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RaMRepo : RaMRepoInterface {
    private val netWorkClient = NetworkService().api
    override suspend fun getAllCharacters(): AllCharactersDto {
        return withContext(Dispatchers.IO) {
            return@withContext netWorkClient.getAllCharacters()
        }
    }

    override suspend fun getAllEpisodes(): Any {
        return ""
    }

    override suspend fun getAllLocation(): Any {
        return ""
    }
}