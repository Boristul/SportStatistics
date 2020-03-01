package com.sports.sportstatistics.repository.network.api

import com.sports.sportstatistics.repository.network.api.model.Data
import com.sports.sportstatistics.repository.network.api.model.Meta
import kotlinx.serialization.SerialName
import retrofit2.http.GET

@Suppress("ComplexInterface")
interface AthletesApi {

    @GET("api/v1/teams")
    suspend fun getAllTeams(): ApiData

    @GET("api/v1/teams/{id}")
    suspend fun getTeam(id: Int): Data
}

data class ApiData(

    @SerialName("data")
    val data: List<Data>,

    @SerialName("meta")
    val meta: Meta
)