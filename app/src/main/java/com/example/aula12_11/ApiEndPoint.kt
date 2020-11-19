package com.example.aula12_11

import com.example.aula12_11.dominio.User
import retrofit2.Call
import retrofit2.http.GET


interface ApiEndPoint {
    @GET("users")
    fun obterUsuarios(): Call<List<User>>
}
