package com.example.timurmuhortov.dubnabus.presentation.presenter.schedule

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.data.ui.StopViewData
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.domain.IScheduleRepository
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
        private val scheduleRepository: IScheduleRepository,
        private val router: Router
) : MvpPresenter<IScheduleView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        scheduleRepository.loadStopsDataBase()
                .subscribe({
                    viewState.showStopName(
                            it.map {
                                StopViewData(
                                        it.id,
                                        it.name
                                )
                            }
                    )
                }, {
                    it.printStackTrace()
                })


    }

    fun busesDefault(){

    }

    fun onBack() {
        router.exit()
    }

}