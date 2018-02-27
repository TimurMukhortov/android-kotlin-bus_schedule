package com.example.timurmuhortov.dubnabus.presentation.presenter.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleDataBaseRepository
import com.example.timurmuhortov.dubnabus.presentation.view.IMainView
import com.example.timurmuhortov.dubnabus.ui.viewholder.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 18:12
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@FragmentScope
@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router,
        private val repositoryDataBase: IScheduleDataBaseRepository
): MvpPresenter<IMainView>() {

    fun onSchedule(){
        router.navigateTo(Screens.SCHEDULE)
    }

    fun onMap(){
        viewState.createAlertDialog("Упс!", "Раздел находится в разработке. \n Подождите немного ;)")
    }

    fun onAbout(){
        viewState.createAlertDialog("Упс!", "Раздел находится в разработке. \n Подождите немного ;)")
    }

}