package com.github.mag0716.kmmsample

import android.app.Application
import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.api.ApiClientProvider
import com.github.mag0716.kmmsample.repository.GitHubRepositoryRepository

// TODO: Hiltを利用する
class App : Application() {

    // Repository
    val repository: GitHubRepositoryRepository by lazy {
        GitHubRepositoryRepository(apiClient)
    }

    // Data Source
    private val apiClient: ApiClient by lazy {
        ApiClientProvider().provideApiClient()
    }
}