package com.example.timurmuhortov.dubnabus.util.resource

import android.content.Context
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 22:01
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ResourceProvider @Inject constructor(private val context: Context): IResourceProvider {

    override fun getString(id: Int) = context.getString(id)

    override fun getAssets() = context.assets

    override fun getResources() = context.resources

}