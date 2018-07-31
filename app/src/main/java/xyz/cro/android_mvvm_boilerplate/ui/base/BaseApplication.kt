package xyz.cro.android_mvvm_boilerplate.ui.base

import android.app.Application

class BaseApplication : Application() {
    init {
        sApplication = this
    }

    companion object {
        private var sApplication: BaseApplication? = null

        fun getInstance(): BaseApplication = sApplication!!
    }
}