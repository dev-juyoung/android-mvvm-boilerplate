package xyz.cro.android_mvvm_boilerplate.ui.base

import android.app.Application
import org.koin.android.ext.android.startKoin
import xyz.cro.android_mvvm_boilerplate.di.appModule
import xyz.cro.android_mvvm_boilerplate.di.networkModule

class BaseApplication : Application() {
    init {
        sApplication = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, networkModule))
    }

    companion object {
        private var sApplication: BaseApplication? = null

        fun getInstance(): BaseApplication = sApplication!!
    }
}