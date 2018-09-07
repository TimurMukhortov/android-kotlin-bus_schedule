package com.example.timurmuhortov.dubnabus.data.repository.database

import com.example.timurmuhortov.dubnabus.data.entity.Enter
import com.example.timurmuhortov.dubnabus.data.entity.Update
import com.example.timurmuhortov.dubnabus.data.entity.database.StopDB
import com.example.timurmuhortov.dubnabus.data.entity.schedule.Stop
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleDataBaseRepository
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
        private val realm: Realm
) : IScheduleDataBaseRepository {

    override fun getStops() = realm
            .where(StopDB::class.java)
            .findAllAsync()
            .filter { it.isLoaded }




    override fun setStops(stops: List<StopDB>) {
        realm.executeTransactionAsync {
            stops.forEach { stop->
                it.insert(StopDB(stop.id, stop.name))
            }
        }


    }

    override fun getEnter() = Single.just(realm.where(Enter::class.java).findFirst() != null)

    override fun setEnter() = realm.executeTransaction { it.insert(Enter(false)) }

    override fun getUpdate() = realm.where(Update::class.java)
            .findFirstAsync()
            .asFlowable<Update>()
            .filter { it.isLoaded }
            .take(1)
            .map { it }
            .singleOrError()

    override fun setUpdate(date: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}