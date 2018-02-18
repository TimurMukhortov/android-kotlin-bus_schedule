package com.example.timurmuhortov.dubnabus.data.entity

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 20:02
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


data class Stop(
        val name: String,
        val id: Int
){
    override fun toString(): String = name
}