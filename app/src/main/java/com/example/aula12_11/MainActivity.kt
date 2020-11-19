package com.example.aula12_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aula12_11.dominio.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun buscaDados() {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.obterUsuarios()?.enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>?>?, response: Response<List<User>?>?) {
                val lista = response?.body();
                if (lista != null) {
                    for (user in lista) {
                        Log.d("Resposta", user.name.toString())
                    }
                }
            }

            override fun onFailure(call: Call<List<User>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n"+t?.message.toString())
            }
        })
    }

}