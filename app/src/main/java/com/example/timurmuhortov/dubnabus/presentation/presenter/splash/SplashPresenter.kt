package com.example.timurmuhortov.dubnabus.presentation.presenter.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.data.entity.database.StopDB
import com.example.timurmuhortov.dubnabus.data.entity.schedule.Schedule
import com.example.timurmuhortov.dubnabus.data.entity.schedule.Stop
import com.example.timurmuhortov.dubnabus.data.ui.StopViewData
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleAssetRepository
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleDataBaseRepository
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleNetworkRepository
import com.example.timurmuhortov.dubnabus.presentation.view.ISplashView
import com.example.timurmuhortov.dubnabus.ui.viewholder.Screens
import com.example.timurmuhortov.dubnabus.util.retrofit.NetworkError
import ru.terrakok.cicerone.Router
import javax.inject.Inject


/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 19:26
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@FragmentScope
@InjectViewState
class SplashPresenter @Inject constructor(
        private val router: Router,
        //TODO вынести все эти репозитории в Interactor согласно clean architecture
        private val repositoryAsset: IScheduleAssetRepository,
        private val repositoryDataBase: IScheduleDataBaseRepository,
        private val repositoryNetwork: IScheduleNetworkRepository
) : MvpPresenter<ISplashView>() {

    private val handler = Handler()
    private var scheduleList: Schedule? = null

    @Deprecated("Проверить обновление расписания на сервере. Завести переменную в базе и сравнить.")
    private val flag = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        repositoryNetwork.loadSchedule()
                .subscribe({ schedule ->
                    //TODO delete this shit
                    scheduleList = schedule

                    loadStopsBD(schedule)

                }, {
                    (it as? NetworkError)?.let {
                        val error = "Pizda"
                    }
                })

        val firstEnter = firstEntry()
        val lastUpdate =
        if(flag){
           //TODO выгрузить расписание
        } else {
            onMainSreen()
        }

    }

    private fun onMainSreen() {
        handler.postDelayed({
            router.replaceScreen(Screens.MAIN)
        }, 2000)
    }

    private fun firstEntry() = repositoryDataBase.getEnter()

    private fun loadStopsBD(schedule: Schedule){
        val stops: MutableList<StopDB> = mutableListOf()
        schedule.stops.forEach { stop ->
            stops.add(StopDB(stop.id, stop.name))
        }
        repositoryDataBase.setStops(stops)
    }
}