package com.android.assignment.model

data class Category(
    val id: Int,
    val links: CategoryLinks,
    val photo_count: Int,
    val title: String
)