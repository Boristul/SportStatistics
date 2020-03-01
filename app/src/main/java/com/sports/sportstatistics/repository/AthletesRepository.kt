package com.sports.sportstatistics.repository

import com.sports.sportstatistics.MainApplication
import com.sports.sportstatistics.repository.database.entity.Athlete

class AthletesRepository {

    private val athleteDao = MainApplication.database.athleteDao()
    private val athleteApi = MainApplication.api

    suspend fun addAthlete(athlete: Athlete) = athleteDao.insert(athlete)
    suspend fun getAthleteByName(name: String) = athleteDao.getByName(name)
    suspend fun getAll(): List<Athlete> = athleteDao.getAll()

    suspend fun getAllTeams() = athleteApi.getAllTeams().data
    suspend fun getTeamById(id: Int) = athleteApi.getTeam(id)
}
