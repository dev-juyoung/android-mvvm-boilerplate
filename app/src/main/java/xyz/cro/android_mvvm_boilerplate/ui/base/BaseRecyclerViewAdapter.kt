package xyz.cro.android_mvvm_boilerplate.ui.base

import android.support.v7.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T, H : RecyclerView.ViewHolder> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    protected var dataSet = mutableListOf<T>()

    fun addItems(items: List<T>) {
        dataSet.addAll(items)
    }

    fun updateItems(items: List<T>) {
        dataSet = items as MutableList<T>
    }

    fun getItem(position: Int): T? = if (dataSet.isEmpty()) null else dataSet[position]

    fun getItems(): List<T>? = if (dataSet.isEmpty()) null else dataSet

    abstract fun onBindView(holder: H, position: Int)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            onBindView(holder as H, position)

    override fun getItemCount(): Int = if (dataSet.isEmpty()) 0 else dataSet.size
}