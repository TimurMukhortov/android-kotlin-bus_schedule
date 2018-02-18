package com.example.timurmuhortov.dubnabus.presentation.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.timurmuhortov.dubnabus.data.ui.TimeViewData

/**
 * @author: timur.mukhortov
 * date: 09.02.2018
 * time: 4:12
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@StateStrategyType(AddToEndSingleStrategy::class)
interface IScheduleView : MvpView {

    fun showTimes(times: List<TimeViewData>)
}