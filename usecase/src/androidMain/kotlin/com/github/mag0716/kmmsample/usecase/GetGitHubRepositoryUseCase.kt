package com.github.mag0716.kmmsample.usecase

import com.github.mag0716.kmmsample.api.response.RepositoryResponse

interface GetGitHubRepositoryUseCase {
    suspend operator fun invoke(userName: String): List<RepositoryResponse>
}