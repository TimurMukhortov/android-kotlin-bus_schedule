package com.example.timurmuhortov.dubnabus.util.retrofit

import com.google.gson.annotations.SerializedName

/**
 * @author: timur.mukhortov
 * date: 21.02.2018
 * time: 20:30
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class NetworkError : Throwable {

    constructor() : super()

    constructor(message: String) : super() {
        this.message = message
    }

    @SerializedName("message")
    override var message: String? = ""
    @SerializedName("code")
    var code: Int = 0

}