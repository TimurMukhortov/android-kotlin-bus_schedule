package com.example.timurmuhortov.dubnabus.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 22:28
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Module
class GsonModule {

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder().create()
}