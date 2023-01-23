package com.example.orion.doctorgo.GETcall

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.orion.doctorgo.R
import com.example.orion.doctorgo.api.apiInterface
import com.example.orion.doctorgo.baseAdapter
import com.example.orion.doctorgo.doctorList
import com.example.orion.doctorgo.model.D
import com.example.orion.doctorgo.model.listview
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

import kotlinx.coroutines.*
import retrofit2.converter.gson.GsonConverterFactory


open class get()  {
    private val _responce : MutableLiveData<listview> = MutableLiveData()
    val responce : LiveData<listview>
        get() = _responce
    fun getCall(context: Context) {

        val httpClient = OkHttpClient.Builder()
        var HttpLoggingInterceptor = HttpLoggingInterceptor()

        httpClient.addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Requested-With", "X")
                .build()
            chain.proceed(request)
        }

        val gson = GsonBuilder()
            .setLenient()
            .create()
        var retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
//        .addConverterFactory(ScalarsConverterFactory.create())
//        .client(httpClient.build())
            .baseUrl("http://199.192.26.248:8000/")
            .build()
            .create(apiInterface::class.java)


//            var get = retrofitBuilder.getUsers()
        GlobalScope.launch {
            try {
                var getview = retrofitBuilder.getUsers()

                Log.d("qwerty", getview.toString())
                _responce.value = getview



            } catch (e: Exception) {
                Log.d("qwerty", "Exception: " + e.message)
            }
        }


    }

    }
