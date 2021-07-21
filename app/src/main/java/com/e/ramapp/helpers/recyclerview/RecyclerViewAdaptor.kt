package com.e.ramapp.helpers.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.e.ramapp.helpers.extension.toDisplayModelDisplayType
import com.e.ramapp.viewholders.DisplayTypeUnspecifiedViewHolder

class RecyclerViewAdaptor: ListAdapter<BaseDisplayModel, BaseViewHolder>(RecyclerViewDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return getBaseCardViewHolder(viewType.toDisplayModelDisplayType(), parent)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItem(position).type.ordinal
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getBaseCardViewHolder(
        viewType: DisplayType,
        parent: ViewGroup
    ): BaseViewHolder {
        return when (viewType){
            DisplayType.UNSPECIFIED -> DisplayTypeUnspecifiedViewHolder.getInstance(parent)
        }
    }
}

class RecyclerViewDiffCallback : DiffUtil.ItemCallback<BaseDisplayModel>() {
    override fun areItemsTheSame(oldItem: BaseDisplayModel, newItem: BaseDisplayModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BaseDisplayModel, newItem: BaseDisplayModel): Boolean {
        return oldItem == newItem
    }
}