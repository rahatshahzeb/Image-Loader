package com.android.assignment.binding

import android.graphics.Color
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.android.assignment.model.Image
import com.android.assignment.util.toDp
import com.android.imageloader.PhotoView
import java.net.URL
import javax.inject.Inject

/**
 * Binding adapters that work with a fragment instance.
 */
class FragmentBindingAdapters @Inject constructor(val fragment: Fragment) {

    @BindingAdapter("imageUrl")
    fun bindImage(view: PhotoView, image: Image) {
        val urlPhoto = URL(image.urls.regular)
        view.layoutParams.height = if (((image.height) / 2).toDp > 600) 600 else ((image.height) / 2).toDp
        view.layoutParams.width = if (((image.width) / 2).toDp > 600) 600 else ((image.width) / 2).toDp
        view.setBackgroundColor(Color.parseColor(image.color))
        view.setImageURL(urlPhoto, true, null)
    }
}

