package xyz.cro.android_mvvm_boilerplate.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {
    // Dependency For Shared Preferences
    bean { get<Context>().getSharedPreferences("app-pref", Context.MODE_PRIVATE) as SharedPreferences }
}