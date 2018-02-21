package com.example.timurmuhortov.dubnabus.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 3:36
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


@Module
class RealmModule {

    @Provides
    @Singleton
    fun provideConfig(context: Context) = Realm.init(context).run {
        RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
    }

    @Provides
    @Singleton
    fun provideRealm(config: RealmConfiguration) =
            Realm.getInstance(config)

}