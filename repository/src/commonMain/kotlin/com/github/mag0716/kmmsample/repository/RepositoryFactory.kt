package com.github.mag0716.kmmsample.repository

import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.datasource.GitHubRepositoryCacheSource

// FIXME: DIライブラリを利用して実装を簡略化する
object RepositoryFactory {
    fun provideGitHubRepositoryRepository(
        apiClient: ApiClient,
        cacheSource: GitHubRepositoryCacheSource
    ): GitHubRepositoryRepository = RealGitHubRepositoryRepository(apiClient, cacheSource)
}