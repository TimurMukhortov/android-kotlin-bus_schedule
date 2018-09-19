package com.example.timurmuhortov.dubnabus.engine.repository.database

import com.example.timurmuhortov.dubnabus.engine.data.schedule.BusModel
import com.example.timurmuhortov.dubnabus.engine.data.schedule.DayModel
import com.example.timurmuhortov.dubnabus.engine.data.schedule.StationModel
import com.example.timurmuhortov.dubnabus.engine.domain.irepository.IScheduleDataBaseRepository
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 25.02.2018
 * time: 12:48
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleDataBaseRepository @Inject constructor(
        private val realmInstance: Realm
) : IScheduleDataBaseRepository {

    override fun getStations(): Single<List<StationModel>> =
            Single.fromCallable {
                realmInstance
                        .where(StationModel::class.java)
                        .findAll()
            }

    override fun getBuses(): RealmResults<BusModel> =
            realmInstance
                    .where(BusModel::class.java)
                    .findAll()

    override fun getDays(): RealmResults<DayModel> =
            realmInstance
                    .where(DayModel::class.java)
                    .findAll()

}