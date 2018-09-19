package com.example.timurmuhortov.dubnabus.engine.data.schedule

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * @author: timur.mukhortov
 * date: 09.09.2018
 * time: 15:28
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


open class BusModel(
        @PrimaryKey
        var id: Int? = 0,
        var hours: RealmList<HourModel>? = null
) : RealmObject()