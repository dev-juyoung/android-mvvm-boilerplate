package xyz.cro.android_mvvm_boilerplate.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class ArchitectureFragment<B : ViewDataBinding, VM: BaseViewModel> : BaseFragment() {
    protected abstract var viewModel: VM
    protected lateinit var viewDataBinding: B

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return viewDataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewDataBinding.unbind()
    }
}