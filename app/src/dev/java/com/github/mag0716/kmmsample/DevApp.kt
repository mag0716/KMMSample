package com.github.mag0716.kmmsample

import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.fakeapi.ApiClientProvider

class DevApp : App() {
    override fun provideApiClient(): ApiClient {
        return ApiClientProvider().provideApiClient()
    }
}