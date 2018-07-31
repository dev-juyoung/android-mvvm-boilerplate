package xyz.cro.android_mvvm_boilerplate.ui.base

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber
import xyz.cro.android_mvvm_boilerplate.di.appModule
import xyz.cro.android_mvvm_boilerplate.di.networkModule
import xyz.cro.android_mvvm_boilerplate.extensions.isDebuggable

class BaseApplication : Application() {
    init {
        sApplication = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, networkModule))

        if (!isDebuggable()) return
        initializeDevTools()
    }

    private fun initializeDevTools() {
        // Timber
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        private var sApplication: BaseApplication? = null

        fun getInstance(): BaseApplication = sApplication!!
    }
}