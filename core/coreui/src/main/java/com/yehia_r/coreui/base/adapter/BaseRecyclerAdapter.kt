package com.aait.coreui.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerAdapter<MODEL : Any, VIEW_BINDING : ViewBinding, VIEW_HOLDER : BaseViewHolder<MODEL, VIEW_BINDING>>
    (callback: DiffUtil.ItemCallback<MODEL>) : ListAdapter<MODEL, VIEW_HOLDER>(callback) {

    override fun onBindViewHolder(holder: VIEW_HOLDER, position: Int) {
        holder.doBindings((getItem(position)))
        holder.bind()
        holder.bind(position)
    }

    fun onCurrentListChanged() {
        super.onCurrentListChanged(emptyList(), this.currentList)
    }

    override fun submitList(items: List<MODEL>?) {
        super.submitList(items ?: emptyList())
    }

    override fun getCurrentList(): MutableList<MODEL> {
        return super.getCurrentList()
    }

}