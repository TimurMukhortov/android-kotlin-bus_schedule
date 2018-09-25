package com.example.timurmuhortov.dubnabus.presentation.presenter.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.engine.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.engine.domain.irepository.IScheduleNetworkRepository
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
        private val repositoryNetwork: IScheduleNetworkRepository
) : MvpPresenter<ISplashView>() {

    private val handler = Handler()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repositoryNetwork
                .updateSchedule()
                .subscribe()
        onMainScreen()
    }

    private fun onMainScreen() {
        handler.postDelayed({
            router.replaceScreen(Screens.MAIN)
        }, 2000)
    }

}