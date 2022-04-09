package com.github.mag0716.kmmsample

import android.app.Application
import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.api.ApiClientProvider
import com.github.mag0716.kmmsample.repository.GitHubRepositoryRepository
import com.github.mag0716.kmmsample.repository.RepositoryFactory
import com.github.mag0716.kmmsample.usecase.GetGitHubRepositoryUseCase
import com.github.mag0716.kmmsample.usecase.UseCaseFactory

// TODO: Hiltを利用する
open class App : Application() {

    // UseCase
    fun provideGetGitHubRepositoryUseCase(): GetGitHubRepositoryUseCase {
        return UseCaseFactory.provideGetGitHubRepositoryUseCase(repository)
    }

    // Repository
    private val repository: GitHubRepositoryRepository by lazy {
        RepositoryFactory.provideGitHubRepositoryRepository(apiClient)
    }

    // Data Source
    private val apiClient: ApiClient by lazy {
        provideApiClient()
    }

    open fun provideApiClient(): ApiClient {
        return ApiClientProvider().provideApiClient()
    }
}