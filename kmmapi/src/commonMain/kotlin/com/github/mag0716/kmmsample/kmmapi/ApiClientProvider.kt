package com.github.mag0716.kmmsample.kmmapi

expect class ApiClientProvider {
    fun provideApiClient(): ApiClient
}