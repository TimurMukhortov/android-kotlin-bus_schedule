package com.example.timurmuhortov.dubnabus.presentation.routing

import com.example.timurmuhortov.dubnabus.presentation.routing.base.BaseRouting
import com.example.timurmuhortov.dubnabus.ui.activity.MainActivity
import com.example.timurmuhortov.dubnabus.ui.activity.ScheduleActivity
import com.example.timurmuhortov.dubnabus.ui.viewholder.Screens
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 21:37
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class MainRouting @Inject constructor(
        activity: MainActivity,
        navigatorHolder: NavigatorHolder
) : BaseRouting<MainActivity>(activity, navigatorHolder) {

    override fun recognizeCommand(command: Command) {
        when (command) {
            is Forward -> when (command.screenKey) {
                Screens.SCHEDULE -> openActivity(ScheduleActivity.newIntent(activity))
            }
        }
    }

}