package com.example.timurmuhortov.dubnabus.domain.irepository

import com.example.timurmuhortov.dubnabus.data.entity.Update
import com.example.timurmuhortov.dubnabus.data.entity.database.StopDB
import com.example.timurmuhortov.dubnabus.data.entity.schedule.Stop
import com.example.timurmuhortov.dubnabus.data.ui.StopViewData
import io.reactivex.Single
import io.realm.RealmResults

/**
 * @author: timur.mukhortov
 * date: 25.02.2018
 * time: 12:52
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleDataBaseRepository {

    /*
     *
     * Методы проверки на первый запуск приложения.
     *
     */
    fun getEnter(): Single<Boolean>

    fun setEnter()


    /*
    *
    * Методы для проверки даты последнего обновления расписания
    *
     */
    fun getUpdate(): Single<Update>

    fun setUpdate(date: String)

    /*
    *
    * Методы для загрузки расписания в базу
    *
     */
    fun setStops(stops: List<StopDB>)

    fun getStops(): List<StopDB>
}