package com.sports.sportstatistics.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sports.sportstatistics.R
import com.sports.sportstatistics.databinding.FragmentHomeBinding
import com.sports.sportstatistics.ui.second.SecondActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<HomeFragmentViewModel>()

        binding.goButton.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.addButton.setOnClickListener {
            viewModel.addAthlete(
                binding.name.text.toString(),
                binding.age.text.toString().toIntOrNull(),
                binding.sportType.text.toString(),
                binding.height.text.toString().toDoubleOrNull(),
                binding.weight.text.toString().toDoubleOrNull()
            )
            Toast.makeText(requireContext(), R.string.ma_toast_success, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
