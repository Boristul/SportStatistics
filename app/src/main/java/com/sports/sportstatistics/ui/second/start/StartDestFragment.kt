package com.sports.sportstatistics.ui.second.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sports.sportstatistics.R
import com.sports.sportstatistics.databinding.FragmentStartDestBinding

class StartDestFragment : Fragment() {

    private var _binding: FragmentStartDestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartDestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.goToEnd.setOnClickListener {
            findNavController().navigate(R.id.action_startDestFragment_to_endDestFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
