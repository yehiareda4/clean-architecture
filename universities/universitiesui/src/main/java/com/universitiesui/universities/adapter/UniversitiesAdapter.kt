package com.universitiesui.universities.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.aait.coreui.base.adapter.BaseRecyclerAdapter
import com.aait.coreui.base.adapter.BaseViewHolder
import com.aait.homeui.databinding.ItemUniversitiesBinding
import com.universitiesdomain.model.University

class UniversitiesAdapter(
    private val onItemClick: (University) -> Unit
) : BaseRecyclerAdapter<University, ItemUniversitiesBinding, UniversitiesAdapter.ViewHolder>(
    ProductsCallBack
) {

    inner class ViewHolder(private val viewBinding: ItemUniversitiesBinding) :
        BaseViewHolder<University, ItemUniversitiesBinding>(viewBinding) {
        override fun bind() {
            getRowItem()?.let { university ->
                with(viewBinding) {
                    tvName.text = university.name
                    tvState.text = (university.state ?: "").ifEmpty { university.country }

                    clConatiner.setOnClickListener {
                        onItemClick(university)
                    }
                }
            }
        }
    }

    object ProductsCallBack : DiffUtil.ItemCallback<University>() {
        override fun areItemsTheSame(
            oldItem: University, newItem: University
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: University, newItem: University
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUniversitiesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}
