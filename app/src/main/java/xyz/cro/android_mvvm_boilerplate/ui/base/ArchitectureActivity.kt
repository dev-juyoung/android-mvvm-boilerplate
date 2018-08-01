package xyz.cro.android_mvvm_boilerplate.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes

abstract class ArchitectureActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {
    protected abstract val viewModel: VM
    protected lateinit var viewDataBinding: B
    @LayoutRes protected abstract fun getLayoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutResId())
    }

    override fun onDestroy() {
        super.onDestroy()
        viewDataBinding.unbind()
    }
}