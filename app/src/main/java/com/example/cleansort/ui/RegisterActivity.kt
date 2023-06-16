package com.example.cleansort.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cleansort.R
import com.example.cleansort.data.ApiClient
import com.example.cleansort.data.RegisterResponse
import com.example.cleansort.request.RegisterRequest
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var loginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usernameEditText = findViewById(R.id.username_txtR)
        passwordEditText = findViewById(R.id.password_txtR)
        nameEditText = findViewById(R.id.name_txtR)
        registerButton = findViewById(R.id.btn_regist)
        loginTextView = findViewById(R.id.txtLogin)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val name = nameEditText.text.toString()
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()

            register(username, password, name)
        }
        loginTextView.setOnClickListener {
            finish()
        }
    }
    private fun register(username: String, password: String, nama: String) {
        val apiService = ApiClient.create()

        val request = RegisterRequest(username, password, nama)
        val call = apiService.register(request)

        call.enqueue(object : retrofit2.Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ){
                if (response.isSuccessful){
                    val successMessage = "Registrasi Berhasil"
                    showToast(successMessage)
                }else{
                    val errorMessage = "Gagal Melakukan Registrasi"
                    showToast(errorMessage)
                }
            }
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                val failureMessage = "Terjadi kesalahan saat menghubungi server"
                showToast(failureMessage)
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_SHORT).show()
    }
}