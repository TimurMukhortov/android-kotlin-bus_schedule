package com.example.timurmuhortov.dubnabus.di.module.splash

import android.app.Activity
import com.example.timurmuhortov.dubnabus.di.scope.ActivityScope
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.ui.activity.SplashActivity
import com.example.timurmuhortov.dubnabus.ui.fragment.SplashFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 19:16
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Module
abstract class SplashActivityModule {

    @Binds
    @ActivityScope
    abstract fun activity(activity: SplashActivity): Activity


    @FragmentScope
    @ContributesAndroidInjector
    abstract fun fragment(): SplashFragment
}