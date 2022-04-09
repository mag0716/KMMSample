package com.github.mag0716.kmmsample.usecase

import com.github.mag0716.kmmsample.repository.GitHubRepositoryRepository

class GetGitHubRepositoryUseCase(
    private val repository: GitHubRepositoryRepository
) {
    suspend operator fun invoke(userName: String) =
        repository.getRepositoryList(userName)
}