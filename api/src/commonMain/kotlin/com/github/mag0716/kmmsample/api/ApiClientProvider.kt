package com.github.mag0716.kmmsample.api

expect class ApiClientProvider {
    fun provideApiClient(): ApiClient
}