package xyz.cro.android_mvvm_boilerplate.network.service

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import xyz.cro.android_mvvm_boilerplate.data.model.GithubRepoResponse

interface GithubService {
    @GET("users/{user}/repos")
    fun getUserRepositories(@Path("user") user: String): Observable<List<GithubRepoResponse>>
}