package xyz.cro.android_mvvm_boilerplate.data.source.github

import io.reactivex.Observable
import xyz.cro.android_mvvm_boilerplate.data.model.GithubRepoResponse

interface GithubDataContract {
    fun getUserRepositories(userName: String): Observable<List<GithubRepoResponse>>
}