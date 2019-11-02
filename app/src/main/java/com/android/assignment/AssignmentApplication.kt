package com.android.assignment

import android.app.Activity
import android.app.Application
import com.android.assignment.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AssignmentApplication : Application(), HasActivityInjector {

    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)
    }
}