package com.sports.sportstatistics.ui.second

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sports.sportstatistics.databinding.ActivitySecondBinding
import com.sports.sportstatistics.ui.third.ThirdActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val editText = binding.inputText

        binding.back.setOnClickListener {
            finish()
        }

        binding.toThirdActivity.setOnClickListener {

            editText.text.toString().apply {

                if (this.isNotBlank()) {
                    startActivity(
                        Intent(this@SecondActivity, ThirdActivity::class.java)
                            .putExtra("second_activity", editText.text.toString())
                    )
                } else {
                    Toast.makeText(this@SecondActivity, "Blank value", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.title.text = intent.getStringExtra("Key")
    }
}
