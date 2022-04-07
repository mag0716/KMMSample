package com.github.mag0716.kmmsample.kmmapi

import io.ktor.client.engine.android.*

actual class ApiClientProvider {
    actual fun provideApiClient(): ApiClient =
        ApiClient(Android.create())
}