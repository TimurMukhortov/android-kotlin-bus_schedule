package com.example.timurmuhortov.dubnabus.util.adapter

import com.example.timurmuhortov.dubnabus.data.ui.StopViewData
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 22:43
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@FragmentScope
class StopAdapter @Inject constructor() {

    var stops: List<StopViewData>? = null

    /*
    *
    * Описание: Устанавливаем имена наших остановок
    *
    * Параметры List<StopViewData> - лист с остановками
    *
     */
    fun setStops(stops: List<StopViewData>) {
        this.stops = stops
    }

    /*
    *
    * Описание: Возвращаем имена наших остановок (List<StopViewData>)
    *
    *
     */
    fun getDataStops() = stops


    /*
    *
    * Описание: Возвращает имя остановки по позиции
    *
     */
    fun getStopId(position: Int) = stops?.get(position)?.id


}