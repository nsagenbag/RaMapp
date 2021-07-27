package com.e.ramapp.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.e.ramapp.R
import com.e.ramapp.helpers.recyclerview.BaseDisplayModel
import com.e.ramapp.helpers.recyclerview.BaseViewHolder
import com.e.ramapp.helpers.recyclerview.DisplayType
import kotlinx.android.synthetic.main.vh_dead.view.*
import kotlinx.android.synthetic.main.vh_unspecified.view.*

data class DisplayTypeDeadModel(
    val name: String
) : BaseDisplayModel(DisplayType.UNSPECIFIED)

class DisplayTypeDeadViewHolder(itemView: View): BaseViewHolder(itemView) {
    companion object {
        fun getInstance(parent: ViewGroup): BaseViewHolder {
            val inflater = LayoutInflater.from(parent.context)

            return DisplayTypeDeadViewHolder(
                inflater.inflate(
                    R.layout.vh_dead,
                    parent,
                    false
                )
            )
        }
    }

    override fun bind(item: BaseDisplayModel) {
        val model = item as? DisplayTypeDeadModel
        itemView.txtCharacter.text = model?.name
    }
}