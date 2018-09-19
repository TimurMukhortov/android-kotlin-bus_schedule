package com.example.timurmuhortov.dubnabus.engine.di.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 21:27
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


@Module
class RouterModule {

    private val cicerone = Cicerone.create()

    @Provides
    fun provideRouting() = cicerone.router

    @Provides
    fun provideNavigationHolder() = cicerone.navigatorHolder

}