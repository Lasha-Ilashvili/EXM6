package com.example.exm6.data

import com.example.exm6.R

data class NumPadValue(
    val value: Int,
    val valueType: ValueType,
    val valueLetter: String = ""
) {
    companion object {
        val numPadValueList: List<NumPadValue> = listOf(
            NumPadValue(1, ValueType.NUMBER),
            NumPadValue(2, ValueType.NUMBER, valueLetter = "abc"),
            NumPadValue(3, ValueType.NUMBER, valueLetter = "def"),
            NumPadValue(4, ValueType.NUMBER, valueLetter = "ghi"),
            NumPadValue(5, ValueType.NUMBER, valueLetter = "jkl"),
            NumPadValue(6, ValueType.NUMBER, valueLetter = "mno"),
            NumPadValue(7, ValueType.NUMBER, valueLetter = "pqrs"),
            NumPadValue(8, ValueType.NUMBER, valueLetter = "tuv"),
            NumPadValue(9, ValueType.NUMBER, valueLetter = "wxyz"),
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
