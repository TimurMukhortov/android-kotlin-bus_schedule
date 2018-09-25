package com.example.timurmuhortov.dubnabus.engine.domain.irepository

import com.example.timurmuhortov.dubnabus.engine.data.schedule.ScheduleModel
import io.reactivex.Single

/**
 * @author: timur.mukhortov
 * date: 23.02.2018
 * time: 20:27
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleAssetRepository {

    fun getBaseSchedule(): Single<ScheduleModel>
}