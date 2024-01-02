package com.example.exm6.presentation.secure_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exm6.data.NumFieldValue
import com.example.exm6.databinding.NumFieldItemBinding

class NumFieldItemAdapter :
    ListAdapter<NumFieldValue, NumFieldItemAdapter.NumFieldItemViewHolder>(NumFieldDiffUtil) {

    object NumFieldDiffUtil : DiffUtil.ItemCallback<NumFieldValue>() {
        override fun areItemsTheSame(oldItem: NumFieldValue, newItem: NumFieldValue): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NumFieldValue, newItem: NumFieldValue): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumFieldItemViewHolder {
        return NumFieldItemViewHolder(
            NumFieldItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NumFieldItemViewHolder, position: Int) {
        holder.bind()
    }

    inner class NumFieldItemViewHolder(private val binding: NumFieldItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val numField = currentList[adapterPosition]

            binding.root.background.setTint(
                ContextCompat.getColor(
                    itemView.context,
                    numField.color
                )
            )
        }
    }
}