package com.example.timurmuhortov.dubnabus.util.reader

import com.example.timurmuhortov.dubnabus.util.resource.ResourceProvider
import com.google.gson.Gson
import io.reactivex.Single
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:55
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class FileReader @Inject constructor(
        private val resourceProvider: ResourceProvider,
        private val gson: Gson
): IFileReader {

    override fun <T> readFromAsset(fileName: String, genericType: Class<T>) = Single.fromCallable {
        gson.fromJson<T>(
                BufferedReader(InputStreamReader(resourceProvider.getAssets().open(fileName))),
                genericType)
    }

}