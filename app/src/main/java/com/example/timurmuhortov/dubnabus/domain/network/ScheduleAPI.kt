package com.example.timurmuhortov.dubnabus.domain.network

import com.example.timurmuhortov.dubnabus.data.entity.Schedule
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author: timur.mukhortov
 * date: 20.02.2018
 * time: 23:46
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface ScheduleAPI {

    /*
    *
    * Получение списка автобусных остановок, номеров автобусов, времени
    *
     */
    @GET("schedule")
    fun getSchedule(): Single<Schedule>
}