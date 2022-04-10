package com.github.mag0716.kmmsample.datasource

import android.content.Context
import androidx.core.content.edit
import com.github.mag0716.kmmsample.api.response.RepositoryResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PreferenceGitHubRepositoryCacheSource(
    private val context: Context
) : GitHubRepositoryCacheSource {

    private val preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    override suspend fun load(userName: String): List<RepositoryResponse>? {
        if (preference.contains("KEY$userName")) {
            return preference.getString("KEY$userName", null)?.let {
                Json.decodeFromString<List<RepositoryResponse>>(it)
            }
        }
        return null
    }

    override suspend fun save(userName: String, repositoryList: List<RepositoryResponse>) {
        preference.edit {
            putString("KEY$userName", Json.encodeToString(repositoryList))
        }
    }

    override suspend fun clear(userName: String) {
        preference.edit {
            remove("KEY$userName")
        }
    }

    companion object {
        private const val FILE_NAME = "GitHubRepositoryCache"
        private const val KEY_PREFIX = "GitHubRepository_"
    }
}