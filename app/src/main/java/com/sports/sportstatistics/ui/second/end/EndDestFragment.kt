package com.sports.sportstatistics.ui.second.end

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sports.sportstatistics.R
import com.sports.sportstatistics.databinding.FragmentEndDestBinding

class EndDestFragment : Fragment(R.layout.fragment_end_dest) {

    private var _binding: FragmentEndDestBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentEndDestBinding.bind(view)

        binding.goBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
