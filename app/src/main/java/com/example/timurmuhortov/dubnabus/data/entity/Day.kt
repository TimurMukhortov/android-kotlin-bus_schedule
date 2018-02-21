package com.example.timurmuhortov.dubnabus.data.entity

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 21:39
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Day(
        val id: Int,
        val name: String,
        val buses: List<Bus>
){
    override fun toString(): String = name
}