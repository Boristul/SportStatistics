package com.sports.sportstatistics.ui.main.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sports.sportstatistics.repository.AthletesRepository

class NetworkFragmentViewModel(application: Application) : AndroidViewModel(application) {
    suspend fun getAllTeams() = AthletesRepository().getAllTeams()
    suspend fun getTeam(id: Long) = AthletesRepository().getTeamById(id)
}
