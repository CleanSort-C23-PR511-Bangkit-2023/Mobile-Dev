package com.example.cleansort.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleansort.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBtn()
    }

    private fun setActionBtn(){
        binding.icBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnAbout.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }
        binding.btnContact.setOnClickListener {
            startActivity(Intent(this, ContactUsActivity::class.java))
        }
        binding.btnPrivacy.setOnClickListener {
            startActivity(Intent(this, PrivacyPolicyActivity::class.java))
        }
        binding.btnTerm.setOnClickListener {
            startActivity(Intent(this, TermActivity::class.java))
        }
    }
}