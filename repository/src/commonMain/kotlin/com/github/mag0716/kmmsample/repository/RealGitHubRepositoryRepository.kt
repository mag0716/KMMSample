package com.github.mag0716.kmmsample.repository

import com.github.mag0716.kmmsample.api.ApiClient

internal class RealGitHubRepositoryRepository(
    private val apiClient: ApiClient
) : GitHubRepositoryRepository {
    override suspend fun getRepositoryList(userName: String) = apiClient.repos(userName)
}