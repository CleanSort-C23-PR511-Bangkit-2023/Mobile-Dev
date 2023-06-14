package com.example.cleansort.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleansort.databinding.ActivityOrganicBinding

class OrganicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrganicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrganicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBtn()
    }

    private fun setActionBtn() {
        binding.icBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}