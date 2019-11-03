package com.android.assignment.di

import android.app.Application
import com.android.assignment.AssignmentApplication
import com.android.assignment.di.module.ActivityBindingModule
import com.android.assignment.di.module.NetworkModule
import com.android.assignment.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        ActivityBindingModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(assignmentApplication: AssignmentApplication)
}
