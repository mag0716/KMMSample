package com.github.mag0716.kmmsample

import android.app.Application
import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.api.ApiClientProvider
import com.github.mag0716.kmmsample.repository.GitHubRepositoryRepository
import com.github.mag0716.kmmsample.repository.RealGitHubRepositoryRepository
import com.github.mag0716.kmmsample.usecase.GetGitHubRepositoryUseCase
import com.github.mag0716.kmmsample.usecase.RealGetGitHubRepositoryUseCase

// TODO: Hiltを利用する
open class App : Application() {

    // UseCase
    fun provideGetGitHubRepositoryUseCase(): GetGitHubRepositoryUseCase {
        return RealGetGitHubRepositoryUseCase(repository)
    }

    // Repository
    private val repository: GitHubRepositoryRepository by lazy {
        RealGitHubRepositoryRepository(apiClient)
    }

    // Data Source
    private val apiClient: ApiClient by lazy {
        provideApiClient()
    }

    open fun provideApiClient(): ApiClient {
        return ApiClientProvider().provideApiClient()
    }
}