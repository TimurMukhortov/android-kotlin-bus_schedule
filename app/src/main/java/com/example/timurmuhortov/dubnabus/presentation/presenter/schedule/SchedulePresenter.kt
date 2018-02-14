package com.example.timurmuhortov.dubnabus.presentation.presenter.schedule

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.data.ui.TimeViewData
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
        scheduleRepository
                .loadTimes()
                .subscribe({
                    viewState.showTimes(
                            it.map {
                                TimeViewData(
                                        it.hours,
                                        it.firstMinute,
                                        it.secondMinute,
                                        it.thirdMinute,
                                        it.fourthMinute
                                        )
                            }
                    )
                }, {
                    Log.i("presenter", it.message)
                })


    }

    fun onBack() {
        router.exit()
    }
}