package xyz.cro.android_mvvm_boilerplate.ui.main

import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import xyz.cro.android_mvvm_boilerplate.data.model.GithubRepoResponse
import xyz.cro.android_mvvm_boilerplate.data.source.github.GithubDataContract
import xyz.cro.android_mvvm_boilerplate.network.NetworkError
import xyz.cro.android_mvvm_boilerplate.network.NetworkObserver
import xyz.cro.android_mvvm_boilerplate.ui.base.BaseViewModel

class MainViewModel(private val githubRepository: GithubDataContract) : BaseViewModel() {
    var repoList = MutableLiveData<List<GithubRepoResponse>>()

    fun getUserRepositories(name: String) {
        githubRepository.getUserRepositories(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : NetworkObserver<List<GithubRepoResponse>>(compositeDisposable) {
                    override fun onSuccess(data: List<GithubRepoResponse>) {
                        Timber.d("MainViewModel::onSuccess: ${data[0].toString()}")
                        repoList.value = data
                    }

                    override fun onError(e: NetworkError) {
                        Timber.e("MainViewModel::onError: ${e.toString()}")
                    }
                })
    }
}