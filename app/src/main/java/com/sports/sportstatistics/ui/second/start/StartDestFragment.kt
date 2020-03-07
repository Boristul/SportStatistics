package com.sports.sportstatistics.ui.second.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sports.sportstatistics.R
import com.sports.sportstatistics.databinding.FragmentStartDestBinding

class StartDestFragment : Fragment(R.layout.fragment_start_dest) {

    private var _binding: FragmentStartDestBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentStartDestBinding.bind(view)

        binding.goToEnd.setOnClickListener {
            findNavController().navigate(R.id.action_startDestFragment_to_endDestFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
