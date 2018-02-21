package com.example.timurmuhortov.dubnabus.di.module

import com.example.timurmuhortov.dubnabus.domain.URLS
import com.example.timurmuhortov.dubnabus.util.gson.AnnotationExclusionStrategy
import com.example.timurmuhortov.dubnabus.util.gson.DateAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

/**
 * @author: timur.mukhortov
 * date: 20.02.2018
 * time: 23:08
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder()
            .setLenient()
            .registerTypeAdapter(Date::class.java, DateAdapter())
            .setExclusionStrategies(AnnotationExclusionStrategy())
            .create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient) = Retrofit.Builder()
            .baseUrl(URLS.BACKEND_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

}