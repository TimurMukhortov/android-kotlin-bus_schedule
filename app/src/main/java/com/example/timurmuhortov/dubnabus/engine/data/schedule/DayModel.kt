package com.example.timurmuhortov.dubnabus.engine.data.schedule

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * @author: timur.mukhortov
 * date: 09.09.2018
 * time: 15:21
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


open class DayModel(
        @PrimaryKey
        var id: Long? = 0,
        var buses: RealmList<BusModel>? = null
) : RealmObject()