package com.example.timurmuhortov.dubnabus.engine.data.schedule

import io.realm.RealmList
import io.realm.RealmObject

/**
 * @author: timur.mukhortov
 * date: 09.09.2018
 * time: 15:15
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


open class ScheduleModel(
        var stations: RealmList<StationModel>? = null
) : RealmObject()