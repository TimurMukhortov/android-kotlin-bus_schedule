package com.example.timurmuhortov.dubnabus.presentation.presenter.main

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.presentation.view.IMainView
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 18:12
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@FragmentScope
@InjectViewState
class MainPresenter @Inject constructor(): MvpPresenter<IMainView>() {

    private val mainTag = "MainPresenter"

    fun onSchedule(){
        viewState.createAlertDialog("Ошибка:", "Раздел находится в разработке.")
        Log.i(mainTag, "P. Schedule!")
    }

    fun onMap(){
        viewState.createAlertDialog("Ошибка:", "Раздел находится в разработке.")
        Log.i(mainTag, "P. Map!")
    }

    fun onAbout(){
        viewState.createAlertDialog("Ошибка:", "Раздел находится в разработке.")
        Log.i(mainTag, "P. About!")
    }

}