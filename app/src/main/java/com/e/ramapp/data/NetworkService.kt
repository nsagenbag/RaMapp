package com.e.ramapp.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkService {
    companion object {
        private const val TIMEOUT: Long = 60
        private const val BASEURL: String = "https://rickandmortyapi.com/api/"
    }

    val api = getClient().create(ApiService::class.java)

    fun getClient(): Retrofit {
        val client = OkHttpClient.Builder()

        client.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        client.writeTimeout(TIMEOUT, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }


}