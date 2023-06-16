package com.example.cleansort.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleansort.databinding.ActivityDetectionBinding
import com.example.cleansort.ui.Camera.CameraActivity

class DetectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnMulai.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }
    }
}