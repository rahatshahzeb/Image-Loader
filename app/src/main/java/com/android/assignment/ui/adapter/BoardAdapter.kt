package com.android.assignment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.android.assignment.R
import com.android.assignment.adapter.DataBoundListAdapter
import com.android.assignment.databinding.ItemImageBinding
import com.android.assignment.model.Image
import com.android.assignment.util.AppExecutors

/**
 * A RecyclerView adapter for [Image] class.
 */
class BoardAdapter(
    private val dataBindingComponent: DataBindingComponent,
    appExecutors: AppExecutors,
    private val clickCallback: ((view: View, image: Image) -> Unit)?
) : DataBoundListAdapter<Image, ItemImageBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.user == newItem.user
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.height == newItem.height
                    && oldItem.width == newItem.width
        }
    }
) {

    override fun createBinding(parent: ViewGroup): ItemImageBinding {
        val binding = DataBindingUtil.inflate<ItemImageBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_image,
            parent,
            false,
            dataBindingComponent
        )
        binding.root.setOnClickListener {
            binding.imageObj?.let {image ->
                clickCallback?.invoke(it, image)
            }
        }
        return binding
    }

    override fun bind(binding: ItemImageBinding, item: Image, position: Int) {
        binding.imageObj = item

    }
}
