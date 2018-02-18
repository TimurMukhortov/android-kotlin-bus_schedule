package com.example.timurmuhortov.dubnabus.util.reader

import io.reactivex.Single

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:49
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IFileReader {

    /**
     * Convert given [fileName] to the [T] object
     *
     * @param fileName the file that stores in the assets folder, e.g. /ru/harry-potter.json
     * @param genericType the same class as a [T]
     */
    fun <T> readFromAsset(fileName: String, genericType: Class<T>): Single<T>
}