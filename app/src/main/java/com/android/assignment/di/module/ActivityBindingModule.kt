package com.android.assignment.di.module

import com.android.assignment.ui.MainActivity
import dagger.android.ContributesAndroidInjector
import dagger.Module

@Module
@Suppress("unused")
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}