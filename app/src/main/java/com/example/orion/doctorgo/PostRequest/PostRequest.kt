package com.example.orion.doctorgo.PostRequest

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.orion.doctorgo.api.apiInterface
import com.example.orion.doctorgo.model.userpost
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun PostRequest(context:Context,name:String,gender:String,email:String,practiceMonth:String,practiceYear:String) {
    val httpClient = OkHttpClient.Builder()

    httpClient.addInterceptor { chain ->
        val request: Request = chain.request().newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Content-type","application/json")
            .addHeader("X-Requested-With","X")
            .build()
        chain.proceed(request)
    }
    var retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://199.192.26.248:8000/")
        .client(httpClient.build())
        .build()


    var userpostnn = userpost(email,gender,name,practiceMonth,practiceYear)
    Toast.makeText(context, email, Toast.LENGTH_SHORT).show()
//    var dummy = userpost("aqweerretfrd@gmail.com","m","abrtrcd","23","2002")
    var jsonPlaceholderApi = retrofitBuilder.create(apiInterface::class.java)
    val call = jsonPlaceholderApi.sendUserData(userpostnn)



    call.enqueue(object : Callback<userpost> {
        override fun onResponse(call: Call<userpost>, response: Response<userpost>) {

            Toast.makeText(context, "succefull to make a request", Toast.LENGTH_LONG).show()

        }

        override fun onFailure(call: Call<userpost>, t: Throwable) {
            Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            Log.d("qwerty", t.toString())

        }
    }


    )

}
