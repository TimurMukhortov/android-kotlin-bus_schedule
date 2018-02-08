package com.example.timurmuhortov.dubnabus.presentation.presenter.splash

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.presentation.view.ISplashView
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 19:26
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@FragmentScope
@InjectViewState
class SplashPresenter @Inject constructor(): MvpPresenter<ISplashView>() {

    private val splashTag = "SplashPresenter"

    fun onMain(){
        Log.i(splashTag, "P. Main!")
    }
}