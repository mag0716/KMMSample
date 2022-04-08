package com.github.mag0716.kmmsample.repository

import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.api.response.RepositoryResponse

class GitHubRepositoryRepository(
    private val apiClient: ApiClient
) {
    suspend fun getRepositoryList(userName: String): List<RepositoryResponse> {
        return apiClient.repos(userName)
    }
}