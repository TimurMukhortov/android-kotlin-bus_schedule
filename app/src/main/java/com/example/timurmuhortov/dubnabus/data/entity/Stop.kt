package com.example.timurmuhortov.dubnabus.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 20:02
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Stop(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("days")
        val days: List<Day>
) {
    override fun toString(): String = name
}