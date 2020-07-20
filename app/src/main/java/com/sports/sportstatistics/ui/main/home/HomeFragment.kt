package com.sports.sportstatistics.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sports.sportstatistics.R
import com.sports.sportstatistics.databinding.FragmentHomeBinding
import com.sports.sportstatistics.ui.main.motion.MotionActivity
import com.sports.sportstatistics.ui.second.SecondActivity

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<HomeFragmentViewModel>()
        _binding = FragmentHomeBinding.bind(view)

        binding.goButton.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.motion.setOnClickListener {
            startActivity(Intent(requireContext(), MotionActivity::class.java))
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
