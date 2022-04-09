package com.github.mag0716.kmmsample.repository

import com.github.mag0716.kmmsample.api.ApiClient

// FIXME: DIライブラリを利用して実装を簡略化する
object RepositoryFactory {
    fun provideGitHubRepositoryRepository(
        apiClient: ApiClient
    ): GitHubRepositoryRepository = RealGitHubRepositoryRepository(apiClient)
}