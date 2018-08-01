package xyz.cro.android_mvvm_boilerplate.data.source.github

import io.reactivex.Observable
import xyz.cro.android_mvvm_boilerplate.data.model.GithubRepoResponse
import xyz.cro.android_mvvm_boilerplate.network.service.GithubService

class GithubRepository(private val githubService: GithubService) : GithubDataContract {
    override fun getUserRepositories(userName: String): Observable<List<GithubRepoResponse>> =
            githubService.getUserRepositories(userName)
}