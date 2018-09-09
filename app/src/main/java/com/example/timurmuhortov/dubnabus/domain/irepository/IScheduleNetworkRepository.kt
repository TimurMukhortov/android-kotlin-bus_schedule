package com.example.timurmuhortov.dubnabus.domain.irepository

import com.example.timurmuhortov.dubnabus.data.entity.schedule.Schedule
import io.reactivex.Single

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:29
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleNetworkRepository {

    fun loadSchedule(): Single<Schedule>

}