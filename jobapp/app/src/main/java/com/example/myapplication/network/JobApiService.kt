package com.example.myapplication.network
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val baseURL : String = "https://jobapp-jpcx.onrender.com"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(baseURL)
    .build()


// create interface: defines how Retrofit talks to the web server
interface JobApiService {
    @GET("jobs/alljobs")
    suspend fun getJobInfo() : String
}



object  JobApi {
    val retrofitService : JobApiService by lazy {
        retrofit.create(JobApiService::class.java)
    }
}


/*
this file provides isolation from the network layer and the data layer
we use a singleton object as retrofit create() method consumes a lot: interms of memory, power, processing speed

 */