package com.sports.sportstatistics.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sports.sportstatistics.R
import com.sports.sportstatistics.ui.second.SecondActivity

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<HomeFragmentViewModel>()

        val nameEditText = view.findViewById<EditText>(R.id.am_name_et)
        val ageEditText = view.findViewById<EditText>(R.id.am_age_et)
        val heightEditText = view.findViewById<EditText>(R.id.am_height_et)
        val weightEditText = view.findViewById<EditText>(R.id.am_weight_et)
        val sportTypeEditText = view.findViewById<EditText>(R.id.am_sport_type_et)

        view.findViewById<Button>(R.id.fh_go_button).setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        view.findViewById<Button>(R.id.fh_add_button).setOnClickListener {
            viewModel.addAthlete(
                nameEditText.text.toString(),
                ageEditText.text.toString().toIntOrNull(),
                sportTypeEditText.text.toString(),
                heightEditText.text.toString().toDoubleOrNull(),
                weightEditText.text.toString().toDoubleOrNull()
            )
            Toast.makeText(requireContext(), R.string.ma_toast_success, Toast.LENGTH_LONG).show()
        }
    }
}
