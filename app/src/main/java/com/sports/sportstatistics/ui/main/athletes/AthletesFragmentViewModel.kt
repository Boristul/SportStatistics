package com.sports.sportstatistics.ui.main.athletes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sports.sportstatistics.repository.AthletesRepository

class AthletesFragmentViewModel(application: Application) : AndroidViewModel(application) {

    suspend fun getAthletes() = AthletesRepository().getAll()
}
