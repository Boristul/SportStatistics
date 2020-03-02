package com.sports.sportstatistics.ui.main.teams

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sports.sportstatistics.R
import kotlinx.coroutines.launch

class TeamsFragment : Fragment(R.layout.fragment_network) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<TeamsFragmentViewModel>()

        viewLifecycleOwner.lifecycleScope.launch {
            view.findViewById<TextView>(R.id.fn_text_tv).text = viewModel.getTeam(1).toString()
        }
    }
}
