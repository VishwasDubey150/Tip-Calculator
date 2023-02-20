package com.example.tipmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        supportActionBar?.hide()

        binding.btn.setOnClickListener {
            val cost:Double=binding.et.text.toString().toDouble()
            val selected:Int=binding.rg.checkedRadioButtonId

            val tipp=when(selected)
            {
                R.id.perfect->0.1
                R.id.good->0.07
                else -> 0.05
            }

            var totaltip=tipp*cost
            binding.tt.text="Total tip to be paid is ₹"+totaltip.toString()
        }
    }
}