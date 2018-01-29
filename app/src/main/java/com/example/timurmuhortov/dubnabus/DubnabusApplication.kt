package com.example.timurmuhortov.dubnabus

import android.app.Activity
import android.app.Application
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

    @Inject
    protected lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .builder()
                .context(this)
                .build()
                .inject(this)
    }

    override fun activityInjector() = dispatchingActivityInjector
}