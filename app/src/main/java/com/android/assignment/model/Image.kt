package com.android.assignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Image(
    val categories: List<Category>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<@RawValue Any>,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val urls: Urls,
    val user: User,
    val width: Int
): Parcelable