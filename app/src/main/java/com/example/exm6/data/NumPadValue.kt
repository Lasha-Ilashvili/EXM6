package com.example.exm6.data

import com.example.exm6.R

data class NumPadValue(
    val value: Int,
    val valueType: ValueType
) {
    companion object {
        val numPadValueList: List<NumPadValue> = listOf(
            NumPadValue(1, ValueType.NUMBER),
            NumPadValue(2, ValueType.NUMBER),
            NumPadValue(3, ValueType.NUMBER),
            NumPadValue(4, ValueType.NUMBER),
            NumPadValue(5, ValueType.NUMBER),
            NumPadValue(6, ValueType.NUMBER),
            NumPadValue(7, ValueType.NUMBER),
            NumPadValue(8, ValueType.NUMBER),
            NumPadValue(9, ValueType.NUMBER),
            NumPadValue(R.drawable.ic_touch_id, ValueType.ICON),
            NumPadValue(0, ValueType.NUMBER),
            NumPadValue(R.drawable.ic_backspace, ValueType.ICON),
        )
    }
}

enum class ValueType {
    NUMBER,
    ICON
}
