package com.example.timurmuhortov.dubnabus.engine.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import java.lang.Exception
import javax.inject.Singleton

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 3:36
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


@Module
class RealmModule(context: Context) {

    private companion object {
        const val DB_NAME = "DubnaBus"
    }

    @Provides
    @Singleton
    fun provideConfig(context: Context) = Realm.init(context).run {
        RealmConfiguration
                .Builder()
                .name(DB_NAME)
                .deleteRealmIfMigrationNeeded()
                .build()
    }

    @Provides
    @Singleton
    fun provideRealm(config: RealmConfiguration) =
            Realm.getInstance(config)

}