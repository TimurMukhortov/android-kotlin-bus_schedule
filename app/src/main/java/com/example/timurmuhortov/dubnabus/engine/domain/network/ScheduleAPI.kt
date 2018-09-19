package com.example.timurmuhortov.dubnabus.engine.domain.network

import com.example.timurmuhortov.dubnabus.engine.data.schedule.ScheduleModel
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author: timur.mukhortov
 * date: 20.02.2018
 * time: 23:46
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface ScheduleAPI {

    /**
     * Get schedule from server
     */
    @GET("schedule")
    fun getUpdateSchedule(): Single<ScheduleModel>

    /**
     * Get last version schedule from server
     */
    @GET("updated")
    fun getVersionSchedule(): Single<Long>
}