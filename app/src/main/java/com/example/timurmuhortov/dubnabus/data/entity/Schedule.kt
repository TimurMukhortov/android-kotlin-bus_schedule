package com.example.timurmuhortov.dubnabus.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author: timur.mukhortov
 * date: 21.02.2018
 * time: 20:09
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Schedule(
        @SerializedName("stops")
        val stops: List<Stop>
)