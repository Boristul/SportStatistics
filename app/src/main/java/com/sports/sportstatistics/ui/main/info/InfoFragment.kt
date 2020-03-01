package com.sports.sportstatistics.ui.main.info

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sports.sportstatistics.R
import kotlinx.coroutines.launch

class InfoFragment : Fragment(R.layout.fragment_info) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewModel by viewModels<InfoFragmentViewModel>()

        viewLifecycleOwner.lifecycleScope.launch {
            view.findViewById<TextView>(R.id.fi_info_tv).text =
                viewModel.getAthletes().joinToString("\n\n")
        }
        viewLifecycleOwner.lifecycleScope.launch {

            val teams = viewModel.getAllTeams()
            val team = viewModel.getTeam(1)
            Log.d("TEAMS", teams.size.toString())
            Log.d("TEAM", team.fullName)
        }

    }
}
