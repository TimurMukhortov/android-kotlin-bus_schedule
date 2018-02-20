package com.example.timurmuhortov.dubnabus.util.adapter

import com.example.timurmuhortov.dubnabus.data.ui.DayViewData
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 18.02.2018
 * time: 22:44
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@FragmentScope
class DayAdapter @Inject constructor() {

    private val days = arrayListOf(DayViewData(0,"Будни"), DayViewData(5, "Суббота"), DayViewData(6, "Воскресенье"))

    /*
*
* Описание: Возвращаем имена наших остановок (List<StopViewData>)
*
*
 */
    fun getDays() = days

    /*
    *
    * Описание: Возвращает имя остановки по позиции
    *
     */
    fun getStopId(position: Int) = days[position].id

}