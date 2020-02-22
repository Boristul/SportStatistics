package com.sports.sportstatistics.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sports.sportstatistics.R
import com.sports.sportstatistics.second.SecondActivity

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<Button>(R.id.fh_go_button).setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }
    }
}
