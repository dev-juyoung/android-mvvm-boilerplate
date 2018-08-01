package xyz.cro.android_mvvm_boilerplate.network

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import xyz.cro.android_mvvm_boilerplate.data.source.sharedpref.PreferencesDataContract
import java.io.IOException

class AuthenticationInterceptor(private val prefRepository: PreferencesDataContract) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder().apply {
            // 서버와 사전 논의 된 필요 Header 데이터를 추가.
            addHeader(KEY_OS_TYPE, VALUE_OS_TYPE)
        }

        // Header에 Token 데이터 확인 후 추가
        val token = prefRepository.getToken()
        Timber.d("tAuthenticationInterceptor::token: $token")
        if (!token.isNullOrEmpty()) builder.addHeader(KEY_AUTHORIZATION, token)

        return chain.proceed(builder.build())
    }

    companion object {
        // 통신에 필요한 Header의 Keys
        private const val KEY_OS_TYPE = "x-application-os-type"
        private const val KEY_AUTHORIZATION = "Authorization"

        // 통신에 필요한 Header의 정적 데이터
        private const val VALUE_OS_TYPE = "android"
    }
}