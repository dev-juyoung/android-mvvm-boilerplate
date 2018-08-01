package xyz.cro.android_mvvm_boilerplate.data.source.sharedpref

import android.content.SharedPreferences
import androidx.core.content.edit
import xyz.cro.android_mvvm_boilerplate.util.Constants

class PreferencesRepository(private val pref: SharedPreferences) : PreferencesDataContract {
    override fun setToken(token: String) {
        pref.edit {
            putString(Constants.PREF_TOKEN, token)
        }
    }

    override fun getToken(): String = pref.getString(Constants.PREF_TOKEN, "")
}