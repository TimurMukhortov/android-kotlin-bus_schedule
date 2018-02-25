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

    private var buses: List<BusViewData>? = null

    /*
    *
    * Описание: Устанавливаем имена наших автобусов
    *
    * Параметры List<BusViewData> - лист с автобусами
    *
     */
    fun setBuses(buses: List<BusViewData>) {
        this.buses = buses
    }

    /*
    *
    * Описание: Возвращаем номера наших автобусов (List<BusViewData>)
    *
    *
     */
    fun getBuses() = buses

    /*
    *
    * Описание: Возвращает номер автобуса по позиции
    *
     */
    fun getBusId(position: Int) = buses?.get(position)?.id ?: 0

}