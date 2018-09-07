package com.example.timurmuhortov.dubnabus.data.entity.schedule

import com.google.gson.annotations.SerializedName

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 20:31
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Bus(
        @SerializedName("id")
        val id: Int,
        @SerializedName("hours")
        val hours: List<Hour>,
        val id_bus: Int? = 0,
        val id_day: Int? = 0
) {
    override fun toString(): String = "№ " + id.toString()
}