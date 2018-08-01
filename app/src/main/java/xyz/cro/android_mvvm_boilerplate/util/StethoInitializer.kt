package xyz.cro.android_mvvm_boilerplate.util

import android.content.Context
import com.facebook.stetho.Stetho

object StethoInitializer {
    fun init(context: Context) {
        Stetho.initialize(
            Stetho.newInitializerBuilder(context)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                .build()
        )
    }
}