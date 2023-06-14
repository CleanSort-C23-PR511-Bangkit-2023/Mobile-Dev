package com.example.cleansort.data

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("post")
    fun getPost(): Call<ArrayList<PostResponse>>
}