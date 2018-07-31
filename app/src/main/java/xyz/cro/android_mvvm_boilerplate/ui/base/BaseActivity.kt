package xyz.cro.android_mvvm_boilerplate.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import xyz.cro.android_mvvm_boilerplate.extensions.isDebuggable

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 스크린 방향 PORTRAIT 고정
        try {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } catch (e: IllegalArgumentException) {
            if (isDebuggable()) e.printStackTrace()
        }

        // Activity 진입 시 키보드 옵션 설정
        window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )
    }
}