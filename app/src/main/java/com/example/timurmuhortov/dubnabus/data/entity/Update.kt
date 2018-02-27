package com.example.timurmuhortov.dubnabus.data.entity

import io.realm.RealmObject

/**
 * @author: timur.mukhortov
 * date: 25.02.2018
 * time: 20:34
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/
 
 
open class Update(
        //default empty value
        var lastScheduleUpdate: String? = "-1"
): RealmObject()