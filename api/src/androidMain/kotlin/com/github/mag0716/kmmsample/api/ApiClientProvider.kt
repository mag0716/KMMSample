package com.github.mag0716.kmmsample.api

import io.ktor.client.engine.android.*

actual class ApiClientProvider {
    actual fun provideApiClient(): ApiClient =
        ApiClient(Android.create())
}