package com.github.mag0716.kmmsample.datasource

import com.github.mag0716.kmmsample.api.response.RepositoryResponse

interface GitHubRepositoryCacheSource {
    suspend fun load(userName: String): List<RepositoryResponse>?
    suspend fun save(userName: String, repositoryList: List<RepositoryResponse>)
    suspend fun clear(userName: String)
}