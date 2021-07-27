package com.e.ramapp.helpers.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.util.*

enum class DisplayType {
    UNSPECIFIED,
}

abstract class BaseDisplayModel(
    val type: DisplayType,
    val id: String = UUID.randomUUID().toString()
)

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: BaseDisplayModel)
}