package xyz.cro.android_mvvm_boilerplate.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.dsl.module.applicationContext
import xyz.cro.android_mvvm_boilerplate.data.source.sharedpref.PreferencesDataContract
import xyz.cro.android_mvvm_boilerplate.data.source.sharedpref.PreferencesRepository
import xyz.cro.android_mvvm_boilerplate.util.Constants

val appModule = applicationContext {
    // Dependency For Shared Preferences
    bean { get<Context>().getSharedPreferences(Constants.PREFERENCES_NAME, Context.MODE_PRIVATE) as SharedPreferences }
    bean { PreferencesRepository(get()) as PreferencesDataContract }
}