package com.sports.sportstatistics.ui.main.teams

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sports.sportstatistics.repository.AthletesRepository

class TeamsFragmentViewModel(application: Application) : AndroidViewModel(application) {
    suspend fun getAllTeams() = AthletesRepository().getAllTeams()
    suspend fun getTeam(id: Long) = AthletesRepository().getTeamById(id)
}
