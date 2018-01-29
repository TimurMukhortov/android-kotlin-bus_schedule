package com.example.timurmuhortov.dubnabus.di.module.main

import android.app.Activity
import com.example.timurmuhortov.dubnabus.ui.activity.MainActivity
import com.example.timurmuhortov.dubnabus.di.scope.ActivityScope
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.ui.fragment.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 2:27
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Module
abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract fun activity(activity: MainActivity): Activity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun mainFragmentInjector(): MainFragment
}