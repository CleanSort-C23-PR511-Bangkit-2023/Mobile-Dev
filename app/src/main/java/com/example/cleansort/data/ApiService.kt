package com.example.cleansort.data

import com.example.cleansort.request.LoginRequest
import com.example.cleansort.request.RegisterRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @POST("user/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
    @POST("user/register")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
    @Multipart
    @POST("/predict")
    fun uploadImage(
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): Call<UploadResponse>
}