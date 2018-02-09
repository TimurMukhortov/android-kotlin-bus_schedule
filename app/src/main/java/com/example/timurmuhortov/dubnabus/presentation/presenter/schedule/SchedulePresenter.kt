package com.example.timurmuhortov.dubnabus.presentation.presenter.schedule

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.presentation.view.IScheduleView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 09.02.2018
 * time: 4:15
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


@FragmentScope
@InjectViewState
class SchedulePresenter @Inject constructor(
    private val router: Router
) : MvpPresenter<IScheduleView>() {

    fun onBack(){
        router.exit()
    }
}