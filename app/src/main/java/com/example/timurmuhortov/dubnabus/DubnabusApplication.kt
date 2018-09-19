package com.example.timurmuhortov.dubnabus

import android.app.Activity
import android.app.Application
import com.example.timurmuhortov.dubnabus.engine.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 2:36
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class DubnabusApplication : Application(), HasActivityInjector {

    companion object {
        lateinit var instance: DubnabusApplication
    }

    @Inject
    protected lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        instance = this

        DaggerAppComponent
                .builder()
                .context(this)
                .build()
                .inject(this)

    }

    override fun activityInjector() = dispatchingActivityInjector
}