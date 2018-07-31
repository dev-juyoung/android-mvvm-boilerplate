package xyz.cro.android_mvvm_boilerplate.network.service

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface SampleService {
    @GET("users")
    fun getUsers(): Call<JsonArray>
}