package com.example.cleansort.ui.Setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleansort.databinding.ActivityTermBinding

class TermActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBtn()
    }

    private fun setActionBtn(){
        binding.icBack.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }
}