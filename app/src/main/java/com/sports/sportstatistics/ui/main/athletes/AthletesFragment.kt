package com.sports.sportstatistics.ui.main.athletes

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sports.sportstatistics.R
import kotlinx.coroutines.launch

class AthletesFragment : Fragment(R.layout.fragment_athletes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<AthletesFragmentViewModel>()

        viewLifecycleOwner.lifecycleScope.launch {
            view.findViewById<TextView>(R.id.fi_info_tv).text =
                viewModel.getAthletes().joinToString("\n\n")
        }
    }
}
