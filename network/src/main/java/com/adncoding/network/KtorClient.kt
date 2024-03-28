package com.adncoding.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.Serializable
import javax.inject.Inject

/**
 * Created by AidenChang 2024/03/25
 */
class KtorClient @Inject constructor(private val httpClient: HttpClient) {
    suspend fun getCharacter(id: Int): Character {
        return httpClient.get("character/$id").body()
    }
}

@Serializable
data class Character(
    val id: Int,
    val name: String,
    val origin: Origin
) {
    @Serializable
    data class Origin(
        val name: String
    )
}