package com.example.timurmuhortov.dubnabus.presentation.presenter.schedule

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.data.entity.Day
import com.example.timurmuhortov.dubnabus.data.entity.Schedule
import com.example.timurmuhortov.dubnabus.data.entity.Stop
import com.example.timurmuhortov.dubnabus.data.ui.BusViewData
import com.example.timurmuhortov.dubnabus.data.ui.StopViewData
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleRepository
import com.example.timurmuhortov.dubnabus.presentation.view.IScheduleView
import com.example.timurmuhortov.dubnabus.util.retrofit.NetworkError
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

    private var scheduleList: Schedule? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        scheduleRepository.loadNetworkSchedule()
                .subscribe({ schedule ->
                    scheduleList = schedule
                    viewState.showStopName(schedule.stops.map {
                        StopViewData(
                                it.id,
                                it.name
                        )
                    })
                }, {
                    (it as? NetworkError)?.let {
                        viewState.showAlertDialog("Ошибка", it.code.toString() + " : " + it.message)
                    }
                })

    }

    fun onBack() {
        router.exit()
    }

    fun getBusesForStop(stopId: Int) = scheduleList?.stops?.forEach { stop ->
        if (stopId == stop.id) {
            stop.days.forEach { day ->
                viewState.showBusName(
                        day.buses.map {
                            BusViewData(
                                    it.id
                            )
                        })
            }
        }
    }


}