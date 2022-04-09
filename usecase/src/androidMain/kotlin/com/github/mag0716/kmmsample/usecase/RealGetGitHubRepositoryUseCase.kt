package com.github.mag0716.kmmsample.usecase

import com.github.mag0716.kmmsample.repository.GitHubRepositoryRepository

internal class RealGetGitHubRepositoryUseCase(
    private val repository: GitHubRepositoryRepository
) : GetGitHubRepositoryUseCase {
    override suspend fun invoke(userName: String) = repository.getRepositoryList(userName)
}