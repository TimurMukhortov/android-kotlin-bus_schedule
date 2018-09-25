package com.example.timurmuhortov.dubnabus.engine.di.module

import com.example.timurmuhortov.dubnabus.ui.activity.MainActivity
import com.example.timurmuhortov.dubnabus.engine.di.module.main.MainActivityModule
import com.example.timurmuhortov.dubnabus.engine.di.module.schedule.ScheduleActivityModule
import com.example.timurmuhortov.dubnabus.engine.di.module.splash.SplashActivityModule
import com.example.timurmuhortov.dubnabus.engine.di.scope.ActivityScope
import com.example.timurmuhortov.dubnabus.ui.activity.ScheduleActivity
import com.example.timurmuhortov.dubnabus.ui.activity.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 2:18
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Module(includes = [(AndroidSupportInjectionModule::class)])
abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun splashActivityInjector(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun mainActivityInjector(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ScheduleActivityModule::class)])
    abstract fun scheduleActivityInjector(): ScheduleActivity

}