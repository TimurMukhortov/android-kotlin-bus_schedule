package com.example.timurmuhortov.dubnabus.presentation.presenter.schedule

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.data.entity.Schedule
import com.example.timurmuhortov.dubnabus.data.ui.BusViewData
import com.example.timurmuhortov.dubnabus.data.ui.HourViewData
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

    private var stopId: Int = 0
    private var busId: Int = 0
    private var dayId: Int = 0

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

    fun getBusesForStop(stopId: Int) {
        this.stopId = stopId
        scheduleList?.stops?.forEach { stop ->
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

    fun getBusesForStopByDay(dayId: Int) {
        this.dayId = dayId
        scheduleList?.stops?.forEach { stop ->
            if (stopId == stop.id) {
                stop.days.forEach { day ->
                    if (day.id == dayId) {
                        viewState.showBusName(
                                day.buses.map {
                                    BusViewData(
                                            it.id
                                    )
                                }
                        )
                    }
                }
            }
        }
    }

    fun getSheduleForBus() = scheduleList?.stops?.forEach { stop ->
        if(stopId == stop.id) {
            stop.days.forEach { day ->
                if (dayId == day.id) {
                    day.buses.forEach { bus ->
                        if (busId == bus.id) {
                            viewState.showHours(
                                    bus.hours.map {
                                        HourViewData(
                                                it.hour,
                                                it.minutes
                                        )
                                    }
                            )
                        }
                    }
                }
            }
        }
    }


}