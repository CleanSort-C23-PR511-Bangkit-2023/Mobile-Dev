package com.example.cleansort.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleansort.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
        binding.btnOrganic.setOnClickListener {
            startActivity(Intent(this, OrganicActivity::class.java))
        }
        binding.btnRecyclable.setOnClickListener {
            startActivity(Intent(this, RecyclableActivity::class.java))
        }
        binding.btnCam.setOnClickListener {
            startActivity(Intent(this, DetectionActivity::class.java))
        }
    }
}