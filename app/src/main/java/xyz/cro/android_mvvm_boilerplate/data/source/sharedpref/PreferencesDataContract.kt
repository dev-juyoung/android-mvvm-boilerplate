package xyz.cro.android_mvvm_boilerplate.data.source.sharedpref

interface PreferencesDataContract {
    fun setToken(token: String)
    fun getToken(): String
}