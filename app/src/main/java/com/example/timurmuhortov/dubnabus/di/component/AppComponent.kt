package com.example.timurmuhortov.dubnabus.di.component

import android.content.Context
import com.example.timurmuhortov.dubnabus.DubnabusApplication
import com.example.timurmuhortov.dubnabus.di.module.AppModule
import com.example.timurmuhortov.dubnabus.di.module.RealmModule
import com.example.timurmuhortov.dubnabus.di.module.RouterModule
import dagger.BindsInstance
import dagger.Component
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 2:17
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Singleton
@Component(modules = [(AppModule::class), (RouterModule::class), (RealmModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(application: DubnabusApplication)
}