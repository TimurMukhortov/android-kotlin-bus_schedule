package com.example.timurmuhortov.dubnabus.util.adapter

import com.example.timurmuhortov.dubnabus.data.ui.BusViewData
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 22:44
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@FragmentScope
class BusAdapter @Inject constructor() {

    var buses: List<BusViewData>? = null

    /*
    *
    * Описание: Устанавливаем имена наших остановок
    *
    * Параметры List<StopViewData> - лист с остановками
    *
     */
    fun setBuses(stops: List<BusViewData>) {
        this.buses = stops
    }

    /*
    *
    * Описание: Возвращаем имена наших остановок (List<StopViewData>)
    *
    *
     */
    fun getDataStops() = buses


    /*
    *
    * Описание: Возвращает имя остановки по позиции
    *
     */
    fun getStopId(position: Int) = buses?.get(position)?.id

}