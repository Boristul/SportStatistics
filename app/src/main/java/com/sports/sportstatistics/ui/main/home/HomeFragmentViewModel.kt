package com.sports.sportstatistics.ui.main.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sports.sportstatistics.repository.AthletesRepository
import com.sports.sportstatistics.repository.database.entity.Athlete
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun addAthlete(name: String, age: Int?, sportType: String?, height: Double?, weight: Double?) =
        viewModelScope.launch {
            AthletesRepository().addAthlete(
                Athlete(name, age ?: 0, height, weight, sportType)
            )
        }
}
