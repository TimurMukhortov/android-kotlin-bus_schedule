package com.example.timurmuhortov.dubnabus.domain.irepository

import com.example.timurmuhortov.dubnabus.data.entity.Schedule
import io.reactivex.Single

/**
 * @author: timur.mukhortov
 * date: 23.02.2018
 * time: 20:27
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleAssetRepository {

    fun loadSchedule(): Single<Schedule>
}