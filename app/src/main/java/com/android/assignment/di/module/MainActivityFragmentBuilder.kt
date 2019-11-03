package com.android.assignment.di.module

import com.android.assignment.ui.fragment.BoardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("unused")
abstract class MainActivityFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeBoardFragment(): BoardFragment
}