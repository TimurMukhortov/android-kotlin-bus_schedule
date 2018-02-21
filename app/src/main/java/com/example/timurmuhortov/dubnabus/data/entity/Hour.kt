package com.example.timurmuhortov.dubnabus.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author: timur.mukhortov
 * date: 21.02.2018
 * time: 20:14
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Hour(
        @SerializedName("hour")
        val hour: Int,
        @SerializedName("minutes")
        var minutes: List<Int>
)