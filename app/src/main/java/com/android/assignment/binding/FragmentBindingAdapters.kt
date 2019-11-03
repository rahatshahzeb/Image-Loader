package com.android.assignment.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import javax.inject.Inject

/**
 * Binding adapters that work with a fragment instance.
 */
class FragmentBindingAdapters @Inject constructor(val fragment: Fragment) {
    
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {

    }
}

