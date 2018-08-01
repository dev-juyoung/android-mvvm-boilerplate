package xyz.cro.android_mvvm_boilerplate.network.service

import com.google.gson.JsonArray
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface SampleService {
    @GET("users")
    fun getUsers(): Call<JsonArray>

    @GET("users/followers")
    fun getFollowers(): Observable<JsonArray>
}