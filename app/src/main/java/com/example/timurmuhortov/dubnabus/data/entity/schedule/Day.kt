package com.example.timurmuhortov.dubnabus.data.entity.schedule

import com.google.gson.annotations.SerializedName

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 21:39
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Day(
        @SerializedName("id")
        val id: Int,
        @SerializedName("buses")
        val buses: List<Bus>
){
    //override fun toString(): String = name
}