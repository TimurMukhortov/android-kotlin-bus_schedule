package com.example.timurmuhortov.dubnabus.di.module

import com.example.timurmuhortov.dubnabus.util.reader.FileReader
import com.example.timurmuhortov.dubnabus.util.reader.IFileReader
import com.example.timurmuhortov.dubnabus.util.resource.IResourceProvider
import com.example.timurmuhortov.dubnabus.util.resource.ResourceProvider
import dagger.Binds
import dagger.Module

import javax.inject.Singleton

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 22:26
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Module
abstract class UtilModule {

    @Singleton
    @Binds
    abstract fun provideResourceProvider(resources: ResourceProvider): IResourceProvider

    @Singleton
    @Binds
    abstract fun provideFileReader(fileReader: FileReader): IFileReader

}