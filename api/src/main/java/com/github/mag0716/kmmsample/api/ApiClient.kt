package com.github.mag0716.kmmsample.api

import com.github.mag0716.kmmsample.api.response.Repository
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class ApiClient(
    private val httpClientEngine: HttpClientEngine
) {
    suspend fun repos(userName: String): List<Repository> = withContext(Dispatchers.IO) {
        HttpClient(
            httpClientEngine
        ) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    json = kotlinx.serialization.json.Json {
                        isLenient = false
                        ignoreUnknownKeys = true
                        allowSpecialFloatingPointValues = true
                        useArrayPolymorphism = false
                    }
                )
            }
        }.use { client ->
            client.get("https://api.github.com/users/$userName/repos")
        }
    }

    companion object {
        fun provideApiClient(): ApiClient = ApiClient(Android.create())
    }
}