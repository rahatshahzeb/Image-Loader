package com.android.assignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserLinks(
    val html: String,
    val likes: String,
    val photos: String,
    val self: String
): Parcelable