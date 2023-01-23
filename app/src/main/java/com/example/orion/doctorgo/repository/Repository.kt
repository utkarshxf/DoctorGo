package com.example.orion.doctorgo.repository

import com.example.orion.doctorgo.api.ApiBuilder.retrofitBuilder
import com.example.orion.doctorgo.model.listview

class Repository {

    suspend fun getCall() : retrofit2.Response<listview>{
        return retrofitBuilder.getUsers()
    }
}