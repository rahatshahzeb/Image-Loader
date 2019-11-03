package com.android.assignment.model

data class User(
    val id: String,
    val links: UserLinks,
    val name: String,
    val profile_image: ProfileImage,
    val username: String
)