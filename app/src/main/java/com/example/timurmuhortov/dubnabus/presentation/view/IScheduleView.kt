package com.example.timurmuhortov.dubnabus.presentation.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.timurmuhortov.dubnabus.data.ui.BusViewData
import com.example.timurmuhortov.dubnabus.data.ui.HourViewData
import com.example.timurmuhortov.dubnabus.data.ui.StopViewData

/**
 * @author: timur.mukhortov
 * date: 09.02.2018
 * time: 4:12
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@StateStrategyType(AddToEndSingleStrategy::class)
interface IScheduleView : MvpView {

    fun showHours(times: List<HourViewData>)

    fun showStopName(stops: List<StopViewData>)

    fun showBusName(buses: List<BusViewData>)

    fun showAlertDialog(title: String, message: String)

    fun showShedule(stops: List<StopViewData>, buses: List<BusViewData>)

}