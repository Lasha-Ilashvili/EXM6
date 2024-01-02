package com.example.exm6.data

import com.example.exm6.R

data class NumFieldValue(
    val id: Int = 0,
    var color: Int = R.color.gray
) {
    companion object {
        const val NUM_FIELD_SIZE = 4

        val numFieldList = listOf(
            NumFieldValue(0),
            NumFieldValue(1),
            NumFieldValue(2 ),
            NumFieldValue(3),
        )
    }
}