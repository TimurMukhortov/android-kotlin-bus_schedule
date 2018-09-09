package com.example.timurmuhortov.dubnabus.di.module

import com.example.timurmuhortov.dubnabus.data.repository.assets.ScheduleAssetRepository
import com.example.timurmuhortov.dubnabus.data.repository.database.ScheduleDataBaseRepository
import com.example.timurmuhortov.dubnabus.data.repository.network.ScheduleNetworkRepository
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleAssetRepository
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleDataBaseRepository
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleNetworkRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:26
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideScheduleNetworkRepository(repository: ScheduleNetworkRepository): IScheduleNetworkRepository

    @Singleton
    @Binds
    abstract fun provideScheduleAssetRepository(repository: ScheduleAssetRepository): IScheduleAssetRepository

    @Singleton
    @Binds
    abstract fun provideScheduleDataBaseRepository(repository: ScheduleDataBaseRepository): IScheduleDataBaseRepository

}