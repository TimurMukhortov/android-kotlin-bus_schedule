package com.example.timurmuhortov.dubnabus.domain.irepository

import com.example.timurmuhortov.dubnabus.data.entity.Bus
import com.example.timurmuhortov.dubnabus.data.entity.Schedule
import com.example.timurmuhortov.dubnabus.data.entity.Stop
import com.example.timurmuhortov.dubnabus.data.entity.Time
import io.reactivex.Single

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:29
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleNetworkRepository {

    fun loadSchedule(): Single<Schedule>

    fun loadStopsDataBase(): Single<List<Time>>

}