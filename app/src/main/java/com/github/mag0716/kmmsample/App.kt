package com.github.mag0716.kmmsample

import android.app.Application
import com.github.mag0716.kmmsample.api.ApiClient
import com.github.mag0716.kmmsample.api.ApiClientProvider
import com.github.mag0716.kmmsample.datasource.GitHubRepositoryCacheSource
import com.github.mag0716.kmmsample.datasource.PreferenceGitHubRepositoryCacheSource
import com.github.mag0716.kmmsample.repository.GitHubRepositoryRepository
import com.github.mag0716.kmmsample.repository.RepositoryFactory
import com.github.mag0716.kmmsample.usecase.GetGitHubRepositoryUseCase
import com.github.mag0716.kmmsample.usecase.UseCaseFactory
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

// TODO: Hiltを利用する
open class App : Application() {

    private val applicationScope = MainScope()

    override fun onCreate() {
        super.onCreate()
        Napier.base(DebugAntilog())
        applicationScope.launch {
            cacheDataSource.clear("mag0716")
        }
    }

    // UseCase
    fun provideGetGitHubRepositoryUseCase(): GetGitHubRepositoryUseCase {
        return UseCaseFactory.provideGetGitHubRepositoryUseCase(repository)
    }

    // Repository
    private val repository: GitHubRepositoryRepository by lazy {
        RepositoryFactory.provideGitHubRepositoryRepository(apiClient, cacheDataSource)
    }

    // Data Source
    private val apiClient: ApiClient by lazy {
        provideApiClient()
    }

    open fun provideApiClient(): ApiClient {
        return ApiClientProvider().provideApiClient()
    }

    private val cacheDataSource: GitHubRepositoryCacheSource by lazy {
        PreferenceGitHubRepositoryCacheSource(this)
    }
}