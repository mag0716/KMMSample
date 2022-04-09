package com.github.mag0716.kmmsample.usecase

import com.github.mag0716.kmmsample.repository.GitHubRepositoryRepository

// FIXME: DIライブラリを利用して実装を簡略化する
object UseCaseFactory {
    fun provideGetGitHubRepositoryUseCase(
        repository: GitHubRepositoryRepository
    ): GetGitHubRepositoryUseCase = RealGetGitHubRepositoryUseCase(repository)
}