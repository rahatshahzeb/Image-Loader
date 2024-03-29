package com.android.assignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val links: CategoryLinks,
    val photo_count: Int,
    val title: String
): Parcelable