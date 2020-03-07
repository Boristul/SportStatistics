package com.sports.sportstatistics.ui.main.teams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sports.sportstatistics.R
import com.sports.sportstatistics.databinding.FragmentTeamsBinding
import kotlinx.coroutines.launch

class TeamsFragment : Fragment(R.layout.fragment_teams) {
    private var _binding: FragmentTeamsBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<TeamsFragmentViewModel>()
        _binding = FragmentTeamsBinding.bind(view)

        viewLifecycleOwner.lifecycleScope.launch {
            binding.fnTextTv.text = viewModel.getTeam(1).toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
