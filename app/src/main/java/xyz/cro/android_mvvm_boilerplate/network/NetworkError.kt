package xyz.cro.android_mvvm_boilerplate.network

data class NetworkError(
    val message: String = "",
    val errorCode: Int = -1,
    val throwable: Throwable? = null
)