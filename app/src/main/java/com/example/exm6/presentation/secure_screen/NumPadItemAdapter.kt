package com.example.exm6.presentation.secure_screen

import android.view.LayoutInflater
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exm6.data.NumPadValue
import com.example.exm6.data.ValueType
import com.example.exm6.databinding.NumPadItemBinding

class NumPadItemAdapter : RecyclerView.Adapter<NumPadItemAdapter.NumPadItemViewHolder>() {

    var itemOnClick: ((Int) -> Unit)? = null

    private lateinit var numPadValueList: List<NumPadValue>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumPadItemViewHolder {
        return NumPadItemViewHolder(
            NumPadItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setData(newList: List<NumPadValue>) {
        numPadValueList = newList
    }

    override fun getItemCount(): Int = numPadValueList.size

    override fun onBindViewHolder(holder: NumPadItemViewHolder, position: Int) {
        holder.bind()
    }

    inner class NumPadItemViewHolder(private val binding: NumPadItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemOnClick?.invoke(adapterPosition)
            }
        }

        fun bind() {
            with(binding) {
                val numPadValue = numPadValueList[adapterPosition]

                tvNumPadValLetter.text = numPadValue.valueLetter

                if (numPadValue.valueType == ValueType.NUMBER) {
                    tvNumPadVal.text = numPadValue.value.toString()
                } else if (numPadValue.valueType == ValueType.ICON) {
                    ivNumPadVal.setImageResource(numPadValue.value)
                    ivNumPadVal.visibility = VISIBLE
                }
            }
        }
    }
}