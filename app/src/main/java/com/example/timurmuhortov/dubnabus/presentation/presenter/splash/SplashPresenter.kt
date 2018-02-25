package com.example.timurmuhortov.dubnabus.presentation.presenter.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleDataBaseRepository
import com.example.timurmuhortov.dubnabus.presentation.view.ISplashView
import com.example.timurmuhortov.dubnabus.ui.viewholder.Screens
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
        private val repositoryDataBase: IScheduleDataBaseRepository
) : MvpPresenter<ISplashView>() {

    private val handler = Handler()

    @Deprecated("Проверить обновление расписания на сервере. Завести переменную в базе и сравнить.")
    private val flag = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val flagT = firstEntry()
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
}