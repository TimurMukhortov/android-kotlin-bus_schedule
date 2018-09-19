package com.example.timurmuhortov.dubnabus.engine.data

import io.realm.RealmObject

/**
 * @author: timur.mukhortov
 * date: 09.09.2018
 * time: 14:37
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/
 
 
open class ConfigModel(
        // current schedule version in app
        var scheduleVersion: Long = 0,
        // how many times the user started the application
        var countOccurences: Long = 0,
        // variable to save the state, whether the user appreciated the application
        var flagStayRating: Boolean = false
) : RealmObject()