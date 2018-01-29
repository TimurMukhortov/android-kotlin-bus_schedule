package com.example.timurmuhortov.dubnabus.di.module

import com.example.timurmuhortov.dubnabus.ui.activity.MainActivity
import com.example.timurmuhortov.dubnabus.di.module.main.MainActivityModule
import com.example.timurmuhortov.dubnabus.di.scope.ActivityScope
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
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun mainActivityInjector(): MainActivity

}