package com.example.timurmuhortov.dubnabus.data.entity

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 20:02
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Stop(
        val id: Int,
        val name: String,
        val day: List<Day>
) {
    override fun toString(): String = name
}