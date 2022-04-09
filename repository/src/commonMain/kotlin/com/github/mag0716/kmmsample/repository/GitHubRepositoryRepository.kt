package com.github.mag0716.kmmsample.repository

import com.github.mag0716.kmmsample.api.response.RepositoryResponse

interface GitHubRepositoryRepository {
    suspend fun getRepositoryList(userName: String): List<RepositoryResponse>
}