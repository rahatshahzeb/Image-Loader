package com.android.assignment.util

import com.android.assignment.BuildConfig

object AssignmentConstants {

    const val PACKAGE_NAME = BuildConfig.APPLICATION_ID

    const val BASE_URL = "https://pastebin.com/raw/wgkJgazE/"

    /**
     * Retrofit configuration
     */
    const val CONNECT_TIMEOUT = 30L
    const val WRITE_TIMEOUT = 30L
    const val READ_TIMEOUT = 30L

    const val TAG_FRAGMENT_BOARD = "boardFragment"
}