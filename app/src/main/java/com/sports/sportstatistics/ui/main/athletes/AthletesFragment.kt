package com.sports.sportstatistics.ui.main.athletes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sports.sportstatistics.R
import com.sports.sportstatistics.databinding.FragmentAthletesBinding
import kotlinx.coroutines.launch

class AthletesFragment : Fragment(R.layout.fragment_athletes) {
    private var _binding: FragmentAthletesBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<AthletesFragmentViewModel>()
        _binding = FragmentAthletesBinding.bind(view)

        lifecycleScope.launch {
            binding.info.text = viewModel.getAthletes().toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
