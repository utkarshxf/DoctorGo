package com.example.orion.doctorgo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {
            val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://199.192.26.248:8000/")
            .build()
            .create(apiInterface::class.java)
}