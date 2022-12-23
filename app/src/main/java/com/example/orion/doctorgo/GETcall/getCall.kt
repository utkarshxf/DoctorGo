package com.example.orion.doctorgo.GETcall

//import org.junit.experimental.theories.DataPoint
import android.content.Context
import android.util.Log
import com.example.orion.doctorgo.api.apiInterface
import com.example.orion.doctorgo.model.responce
import com.google.android.gms.fitness.data.DataPoint
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


@OptIn(DelicateCoroutinesApi::class)
fun getCall(context:Context) {
    val gson = GsonBuilder()
        .setLenient()
        .create()
    var retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("http://199.192.26.248:8000/")
        .build()

    var jsonPlaceholderApi = retrofitBuilder.create(apiInterface::class.java)


    GlobalScope.launch {
        var get = jsonPlaceholderApi.getUsers()
//
         if(get.body() != null){
             try
             {
                 val mysresponce: responce = Gson().fromJson(get.body(), responce::class.java)
                 Log.d("qwerty", "onCreate: ${mysresponce}")
             }
             catch (e : IllegalStateException )
             {

             }

         }
    }

}


//
//get.enqueue(object : Callback<responce> {
//    override fun onResponse(call: Call<responce>, response: Response<responce>) {
//        Toast.makeText(context, "ho gyaa", Toast.LENGTH_LONG).show()
//    }
//
//    override fun onFailure(call: Call<responce>, t: Throwable) {
//        Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
//        Log.d("qwerty", t.toString())
//    }
//
