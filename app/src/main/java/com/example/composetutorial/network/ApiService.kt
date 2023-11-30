package com.example.composetutorial.network

import android.util.Log
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private var mRetrofit: Retrofit? = null

    init {
        configRetrofit()
    }

    private fun configRetrofit() {
        val interceptor = HttpLoggingInterceptor { Log.d("https:", it) }
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        mRetrofit = Retrofit.Builder().baseUrl("https://reqres.in/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
    }


    fun <T> buildService(service: Class<T>): T? {
        return mRetrofit?.create(service)
    }


}

