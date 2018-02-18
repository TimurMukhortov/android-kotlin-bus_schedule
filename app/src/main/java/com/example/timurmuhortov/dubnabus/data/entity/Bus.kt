package com.example.timurmuhortov.dubnabus.data.entity

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 20:31
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Bus(
        val id: Int
) {
    override fun toString(): String = "№ " + id.toString()
}