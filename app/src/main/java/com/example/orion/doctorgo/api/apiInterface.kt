package com.example.orion.doctorgo.api

import com.example.orion.doctorgo.model.responce
import com.example.orion.doctorgo.model.userpost
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface apiInterface {

  @Headers(
      "Accept:application/json",
      "Content-type:application/json",
      "X-Requested-With:X")

    @POST("sap/opu/odata/sap/ZCDS_TEST_REGISTER_CDS/ZCDS_TEST_REGISTER")
  fun sendUserData(
    @Body userpost: userpost
  ): Call<userpost>


    @GET("sap/opu/odata/sap/ZCDS_TEST_REGISTER_CDS/ZCDS_TEST_REGISTER")
    suspend  fun getUsers():Response<String>
}