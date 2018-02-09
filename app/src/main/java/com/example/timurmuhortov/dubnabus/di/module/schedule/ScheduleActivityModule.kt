package com.example.timurmuhortov.dubnabus.di.module.schedule

import android.app.Activity
import com.example.timurmuhortov.dubnabus.di.scope.ActivityScope
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.presentation.routing.ScheduleRouting
import com.example.timurmuhortov.dubnabus.presentation.routing.base.IRoutingBinder
import com.example.timurmuhortov.dubnabus.ui.activity.ScheduleActivity
import com.example.timurmuhortov.dubnabus.ui.fragment.ScheduleFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author: timur.mukhortov
 * date: 09.02.2018
 * time: 4:37
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Module
abstract class ScheduleActivityModule {

    @Binds
    @ActivityScope
    abstract fun activity(activity: ScheduleActivity): Activity

    @Binds
    @ActivityScope
    abstract fun routing(routing: ScheduleRouting) : IRoutingBinder

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun fragment(): ScheduleFragment
}