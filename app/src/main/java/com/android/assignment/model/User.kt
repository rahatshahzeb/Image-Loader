package com.android.assignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: String,
    val links: UserLinks,
    val name: String,
    val profile_image: ProfileImage,
    val username: String
): Parcelable