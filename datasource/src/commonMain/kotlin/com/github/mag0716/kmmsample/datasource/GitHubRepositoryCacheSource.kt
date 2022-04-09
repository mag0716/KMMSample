package com.github.mag0716.kmmsample.datasource

import com.github.mag0716.kmmsample.api.response.RepositoryResponse

interface GitHubRepositoryCacheSource {
    suspend fun load(): List<RepositoryResponse>
    suspend fun save(repositoryList: List<RepositoryResponse>)
    suspend fun clear()
}