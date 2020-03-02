package com.sports.sportstatistics.ui.main.info

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sports.sportstatistics.repository.AthletesRepository

class InfoFragmentViewModel(application: Application) : AndroidViewModel(application) {

    suspend fun getAthletes() = AthletesRepository().getAll()
}
