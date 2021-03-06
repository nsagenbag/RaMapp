package com.e.ramapp.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.e.ramapp.R
import com.e.ramapp.helpers.recyclerview.BaseDisplayModel
import com.e.ramapp.helpers.recyclerview.BaseViewHolder
import com.e.ramapp.helpers.recyclerview.DisplayType
import kotlinx.android.synthetic.main.vh_unspecified.view.*

data class DisplayTypeUnspecifiedModel(
    val any: Any
) : BaseDisplayModel(DisplayType.UNSPECIFIED)

class DisplayTypeUnspecifiedViewHolder(itemView: View): BaseViewHolder(itemView) {
    companion object {
        fun getInstance(parent: ViewGroup): BaseViewHolder {
            val inflater = LayoutInflater.from(parent.context)

            return DisplayTypeUnspecifiedViewHolder(
                inflater.inflate(
                    R.layout.vh_unspecified,
                    parent,
                    false
                )
            )
        }
    }

    override fun bind(item: BaseDisplayModel) {
        val model = item as? DisplayTypeUnspecifiedModel

        if (model == null) {
            val displayText = "Unknown model found: $item"
            itemView.txtUnspecifiedData.text = displayText
        } else {
            itemView.txtUnspecifiedData.text = model.any.toString()
        }
    }
}