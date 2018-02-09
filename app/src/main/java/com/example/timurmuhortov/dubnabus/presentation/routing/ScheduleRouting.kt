package com.example.timurmuhortov.dubnabus.presentation.routing

import com.example.timurmuhortov.dubnabus.presentation.routing.base.BaseRouting
import com.example.timurmuhortov.dubnabus.ui.activity.ScheduleActivity
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 09.02.2018
 * time: 4:44
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleRouting @Inject constructor(
        activity: ScheduleActivity,
        navigatorHolder: NavigatorHolder
) : BaseRouting<ScheduleActivity>(activity, navigatorHolder) {

    override fun recognizeCommand(command: Command) {
        when (command) {
            is Back -> {
                if (!popBack()) activity.finish()
            }
        }
    }

}