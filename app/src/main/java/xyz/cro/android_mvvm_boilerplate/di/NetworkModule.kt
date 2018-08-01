package xyz.cro.android_mvvm_boilerplate.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import xyz.cro.android_mvvm_boilerplate.BuildConfig
import xyz.cro.android_mvvm_boilerplate.network.AuthenticationInterceptor
import xyz.cro.android_mvvm_boilerplate.network.service.SampleService

val networkModule = applicationContext {
    bean(KeySet.BEAN_HEADERS) {
        AuthenticationInterceptor(get()) as Interceptor
    }

    bean(KeySet.BEAN_HTTP_CLIENT) {
        OkHttpClient.Builder()
            .addInterceptor(get(KeySet.BEAN_HEADERS))
            .build()
    }

    bean(KeySet.BEAN_API_SERVER) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(get(KeySet.BEAN_HTTP_CLIENT))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Created Retrofit API Services
    bean {
        get<Retrofit>(KeySet.BEAN_API_SERVER).create(SampleService::class.java) as SampleService
    }
}