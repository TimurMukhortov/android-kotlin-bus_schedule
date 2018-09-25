package com.example.timurmuhortov.dubnabus.engine.domain.irepository

import com.example.timurmuhortov.dubnabus.engine.data.schedule.ScheduleModel
import io.reactivex.Single

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:29
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleNetworkRepository {

    fun checkVersion(): Single<Long>

    fun updateSchedule(): Single<ScheduleModel>
}