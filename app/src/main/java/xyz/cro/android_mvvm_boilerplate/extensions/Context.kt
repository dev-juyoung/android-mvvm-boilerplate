package xyz.cro.android_mvvm_boilerplate.extensions

import android.content.Context
import android.content.pm.ApplicationInfo

fun Context.isDebuggable() = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE