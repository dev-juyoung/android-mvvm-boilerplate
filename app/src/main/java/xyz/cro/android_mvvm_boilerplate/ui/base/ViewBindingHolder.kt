package xyz.cro.android_mvvm_boilerplate.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class ViewBindingHolder<B : ViewDataBinding>(
        @LayoutRes layoutResId: Int,
        parent: ViewGroup
) : BaseViewHolder(
        LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
) {
    protected var viewDataBinding = DataBindingUtil.bind<B>(itemView)
}