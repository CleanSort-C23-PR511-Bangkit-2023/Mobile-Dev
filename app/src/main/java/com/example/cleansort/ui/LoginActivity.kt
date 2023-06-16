package com.example.cleansort.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cleansort.R
import com.example.cleansort.data.ApiClient
import com.example.cleansort.data.LoginResponse
import com.example.cleansort.databinding.ActivityLoginBinding
import com.example.cleansort.request.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.username_txtL)
        passwordEditText = findViewById(R.id.password_txtL)
        loginButton = findViewById(R.id.btn_login)
        registerTextView = findViewById(R.id.txtRegist)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()

            login(username, password)
        }
        registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(username: String, password: String) {
        val apiService = ApiClient.create()

        val request = LoginRequest(username, password)
        val call = apiService.login(request)

        call.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val successMessage = "login Berhasil"
                    showToast(successMessage)
                } else {
                    val errorMessage = "Login Gagal"
                    showToast(errorMessage)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                val failureMessage = "Terjadi Kesalahan"
                showToast(failureMessage)
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
    }
}