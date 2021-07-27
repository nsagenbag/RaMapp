package com.e.ramapp.helpers.extension

import com.e.ramapp.helpers.recyclerview.DisplayType

fun Int?.toDisplayModelDisplayType(): DisplayType {
    return when (this) {
        else -> DisplayType.UNSPECIFIED
    }
}