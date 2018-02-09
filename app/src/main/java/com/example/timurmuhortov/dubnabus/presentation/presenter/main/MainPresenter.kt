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

    fun onSchedule(){
        viewState.createAlertDialog("Ошибка:", "Раздел находится в разработке.")
    }

    fun onMap(){
        viewState.createAlertDialog("Ошибка:", "Раздел находится в разработке.")
    }

    fun onAbout(){
        viewState.createAlertDialog("Ошибка:", "Раздел находится в разработке.")
    }

}