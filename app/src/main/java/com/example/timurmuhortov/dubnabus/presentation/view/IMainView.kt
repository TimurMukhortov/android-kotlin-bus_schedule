package com.example.timurmuhortov.dubnabus.presentation.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * @author: timur.mukhortov
 * date: 04.02.2018
 * time: 19:17
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@StateStrategyType(AddToEndSingleStrategy::class)
interface IMainView : MvpView {

}