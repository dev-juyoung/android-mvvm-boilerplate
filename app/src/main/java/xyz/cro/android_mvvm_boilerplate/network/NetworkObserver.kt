package xyz.cro.android_mvvm_boilerplate.network

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

abstract class NetworkObserver<T>(private val compositeDisposable: CompositeDisposable) : Observer<T> {
    override fun onComplete() {
        Timber.d("NetworkObserver::onComplete")
    }

    override fun onSubscribe(d: Disposable) {
        Timber.d("NetworkObserver::onSubscribe")
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        Timber.d("NetworkObserver::onNext: ${t.toString()}")
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        Timber.e("NetworkObserver::onError: ${e.localizedMessage}")
        val networkError = NetworkError(message = e.localizedMessage, throwable = e)
        onError(networkError)
    }

    abstract fun onSuccess(data: T)
    abstract fun onError(e: NetworkError)
}