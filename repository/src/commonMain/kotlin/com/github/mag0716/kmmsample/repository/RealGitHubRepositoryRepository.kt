package com.github.mag0716.kmmsample.repository

import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.api.response.RepositoryResponse
import com.github.mag0716.kmmsample.datasource.GitHubRepositoryCacheSource

internal class RealGitHubRepositoryRepository(
    private val apiClient: ApiClient,
    private val cacheDataSource: GitHubRepositoryCacheSource
) : GitHubRepositoryRepository {
    override suspend fun getRepositoryList(userName: String): List<RepositoryResponse> {
        val cacheRepositoryList = cacheDataSource.load(userName)
        return if (cacheRepositoryList == null) {
            val fetchedRepositoryList = apiClient.repos(userName)
            cacheDataSource.save(userName, fetchedRepositoryList)
            fetchedRepositoryList
        } else {
            cacheRepositoryList
        }
    }
}