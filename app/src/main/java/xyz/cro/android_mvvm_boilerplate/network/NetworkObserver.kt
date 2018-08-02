package xyz.cro.android_mvvm_boilerplate.network

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
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
        Timber.d("NetworkObserver::onNext: $t")
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        Timber.e("NetworkObserver::onError")
        Timber.e("NetworkObserver::localizedMessage = ${e.localizedMessage}")

        when (e) {
            is HttpException -> {
                Timber.e("NetworkObserver::HttpException")
                Timber.e("NetworkObserver::response:: ${e.response()}")
                onError(NetworkError(e.message(), e.response().code(), e))
            }
            else -> {
                Timber.e("NetworkObserver::OtherException")
                onError(NetworkError(message = e.localizedMessage, throwable = e))
            }
        }
    }

    abstract fun onSuccess(data: T)
    abstract fun onError(e: NetworkError)
}