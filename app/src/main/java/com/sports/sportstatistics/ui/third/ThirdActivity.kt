package com.sports.sportstatistics.ui.third

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sports.sportstatistics.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = intent.getStringExtra("second_activity")

        binding.back.setOnClickListener {
            finish()
        }
    }
}
