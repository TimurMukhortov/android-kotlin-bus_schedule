package com.example.timurmuhortov.dubnabus.util.resource

import android.content.res.AssetManager
import android.content.res.Resources
import android.support.annotation.StringRes

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 22:00
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


interface IResourceProvider {

    fun getString(@StringRes id: Int): String

    fun getAssets(): AssetManager

    fun getResources(): Resources
}