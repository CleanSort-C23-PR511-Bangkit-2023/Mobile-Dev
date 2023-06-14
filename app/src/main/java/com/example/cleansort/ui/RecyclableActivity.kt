package com.example.cleansort.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleansort.databinding.ActivityRecyclableBinding

class RecyclableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBtn()
    }

    private fun setActionBtn(){
        binding.icBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}