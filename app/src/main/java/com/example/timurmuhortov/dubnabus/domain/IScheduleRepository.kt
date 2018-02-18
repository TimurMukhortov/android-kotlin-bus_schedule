package com.example.timurmuhortov.dubnabus.domain

import com.example.timurmuhortov.dubnabus.data.entity.Time
import io.reactivex.Single

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:29
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IScheduleRepository {

    fun loadTimes(): Single<List<Time>>
}