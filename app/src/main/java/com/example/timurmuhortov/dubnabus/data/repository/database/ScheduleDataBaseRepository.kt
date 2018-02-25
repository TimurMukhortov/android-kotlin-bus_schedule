package com.example.timurmuhortov.dubnabus.data.repository.database

import com.example.timurmuhortov.dubnabus.data.entity.Enter
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleDataBaseRepository
import io.reactivex.Single
import io.realm.Realm
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 25.02.2018
 * time: 12:48
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleDataBaseRepository @Inject constructor(
        private val realm: Realm
): IScheduleDataBaseRepository {

    override fun getEnter() = Single.just(realm.where(Enter::class.java).findFirst() != null)

    override fun setEnter() = realm.executeTransaction { it.insert(Enter(false)) }
}