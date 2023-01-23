package com.example.orion.doctorgo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orion.doctorgo.GETcall.get
import com.example.orion.doctorgo.api.apiInterface
import com.example.orion.doctorgo.databinding.FragmentDoctorListBinding
import com.example.orion.doctorgo.model.D
import com.example.orion.doctorgo.model.listview
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_doctor_list.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class doctorList() : Fragment() {
     private  var responce = get()
    lateinit var getview:listview


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding= DataBindingUtil.inflate<FragmentDoctorListBinding>(inflater,
            R.layout.fragment_doctor_list, container,false)
        val httpClient = OkHttpClient.Builder()
        val recyclerView = binding.myrecyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        httpClient.addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Requested-With", "X")
                .build()
            chain.proceed(request)
        }
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://199.192.26.248:8000/")
            .build()
            .create(apiInterface::class.java)

        GlobalScope.launch {
            try {
                recyclerView.adapter = baseAdapter(getview.d.results)


            }
            catch ( e : Exception )
            {
                Log.d( "qwerty", "Exception: " + e.message )
            }
        }

        responce.responce.observe(viewLifecycleOwner){
            var list =it
            Log.d( "chutiya", list.toString() )
        }


        return binding.root
    }

}