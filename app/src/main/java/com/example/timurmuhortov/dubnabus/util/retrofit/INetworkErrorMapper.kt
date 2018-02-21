package com.example.timurmuhortov.dubnabus.util.retrofit

import okhttp3.ResponseBody

/**
 * @author: timur.mukhortov
 * date: 21.02.2018
 * time: 20:30
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface INetworkErrorMapper {

    fun map(throwable: Throwable): NetworkError
    fun map(body: ResponseBody?): NetworkError

}