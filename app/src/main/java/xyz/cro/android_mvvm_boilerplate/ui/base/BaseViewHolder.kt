package xyz.cro.android_mvvm_boilerplate.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer