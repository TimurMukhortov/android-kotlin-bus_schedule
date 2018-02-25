package com.example.timurmuhortov.dubnabus.domain.irepository

import io.reactivex.Single

/**
 * @author: timur.mukhortov
 * date: 25.02.2018
 * time: 12:52
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleDataBaseRepository {

    fun getEnter() : Single<Boolean>

    fun setEnter()

}