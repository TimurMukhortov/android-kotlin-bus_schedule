package com.example.timurmuhortov.dubnabus.data.entity.database

import io.realm.RealmObject

/**
 * @author: timur.mukhortov
 * date: 27.02.2018
 * time: 22:34
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/
 
 
 open class StopDB(
        var id: Int = 0,
        var name: String = ""
) : RealmObject(){
    override fun toString(): String = name
}