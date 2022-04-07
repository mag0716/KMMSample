package com.github.mag0716.kmmsample.api

import com.github.mag0716.kmmsample.api.response.Repository
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class FakeApiClientProvider {
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
                                        Repository(1L, "name", "fullName")
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