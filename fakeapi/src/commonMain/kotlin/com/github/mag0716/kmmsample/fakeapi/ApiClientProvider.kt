package com.github.mag0716.kmmsample.fakeapi

import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.api.response.RepositoryResponse
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ApiClientProvider {
    fun provideApiClient() = ApiClient(
        httpClientEngine = MockEngine.create {
            addHandler { request ->
                val responseHeader =
                    headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                with(request.url.fullPath) {
                    when {
                        endsWith("/repos") -> {
                            respond(
                                content = Json.encodeToString(
                                    listOf(
                                        RepositoryResponse(1L, "name", "fullName")
                                    )
                                ),
                                headers = responseHeader
                            )
                        }
                        else -> error("not support")
                    }
                }
            }
        }
    )
}