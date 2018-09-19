package com.example.timurmuhortov.dubnabus.presentation.presenter.schedule

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.engine.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.engine.domain.irepository.IScheduleDataBaseRepository
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
        private val dataBaseRepository: IScheduleDataBaseRepository,
        private val router: Router
) : MvpPresenter<IScheduleView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val station = dataBaseRepository
                .getStations()
        val s =""
    }

    fun onBack(){
        router.exit()
    }
}