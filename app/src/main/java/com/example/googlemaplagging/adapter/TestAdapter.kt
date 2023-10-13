package com.example.googlemaplagging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.googlemaplagging.R
import com.example.googlemaplagging.databinding.ItemListBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestAdapter @Inject constructor() : ListAdapter<String, TestViewHolder>(
    diff
) {
    companion object {
        val diff = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(position = position)
    }
}

class TestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var _binding = ItemListBinding.bind(view)
    val binding: ItemListBinding = _binding

    fun bind(position: Int) {
        binding.textViewTitle.text = "$position"
        binding.executePendingBindings()
    }
}