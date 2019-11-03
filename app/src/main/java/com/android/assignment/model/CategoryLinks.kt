package com.android.assignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryLinks(
    val photos: String,
    val self: String
): Parcelable