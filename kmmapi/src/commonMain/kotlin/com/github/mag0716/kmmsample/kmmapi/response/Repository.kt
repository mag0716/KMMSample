package com.github.mag0716.kmmsample.kmmapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repository(
    val id: Long,
    val name: String,
    @SerialName("full_name") val fullName: String
)