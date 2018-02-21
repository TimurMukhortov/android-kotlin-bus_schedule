package com.example.timurmuhortov.dubnabus.util.retrofit

import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 21.02.2018
 * time: 20:31
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class NetworkErrorMapper @Inject constructor(private val retrofit: Retrofit): INetworkErrorMapper {

    override fun map(throwable: Throwable): NetworkError {
        return if (throwable is HttpException) {
            map(throwable.response().errorBody())
        }
        //TODO remove string, add crash logging
        else NetworkError("Внутренняя ошибка")
    }

    override fun map(body: ResponseBody?): NetworkError =
            try {
                if (body != null) {
                    val converter = retrofit.responseBodyConverter<NetworkError>(
                            NetworkError::class.java, arrayOfNulls<Annotation>(0))
                    converter.convert(body)
                } else {
                    NetworkError("Внутренняя ошибка")
                }
            } catch (ignore: Exception) {
                NetworkError("Внутренняя ошибка")
            }

}