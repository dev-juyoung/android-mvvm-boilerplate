package xyz.cro.android_mvvm_boilerplate.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding

abstract class ArchitectureActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {
    protected abstract var viewModel: VM
    protected lateinit var viewDataBinding: B

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResID)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewDataBinding.unbind()
    }
}