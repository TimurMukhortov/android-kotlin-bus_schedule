package com.example.timurmuhortov.dubnabus.engine.domain.irepository

import com.example.timurmuhortov.dubnabus.engine.data.schedule.BusModel
import com.example.timurmuhortov.dubnabus.engine.data.schedule.DayModel
import com.example.timurmuhortov.dubnabus.engine.data.schedule.StationModel
import io.reactivex.Single
import io.realm.RealmResults

/**
 * @author: timur.mukhortov
 * date: 25.02.2018
 * time: 12:52
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleDataBaseRepository {

    fun getStations(): Single<List<StationModel>>
    fun getBuses(): RealmResults<BusModel>
    fun getDays(): RealmResults<DayModel>

}