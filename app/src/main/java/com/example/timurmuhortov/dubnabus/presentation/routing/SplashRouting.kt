package com.example.timurmuhortov.dubnabus.presentation.routing

import com.example.timurmuhortov.dubnabus.presentation.routing.base.BaseRouting
import com.example.timurmuhortov.dubnabus.ui.activity.MainActivity
import com.example.timurmuhortov.dubnabus.ui.activity.SplashActivity
import com.example.timurmuhortov.dubnabus.ui.viewholder.Screens
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 21:10
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class SplashRouting @Inject constructor(
        activity: SplashActivity,
        navigatorHolder: NavigatorHolder
) : BaseRouting<SplashActivity>(activity, navigatorHolder) {

    override fun recognizeCommand(command: Command) {
        when(command){
            is Replace -> {
                when (command.screenKey) {
                    Screens.MAIN -> {
                        openActivity(MainActivity.newIntent(activity))
                        activity.finish()
                    }
                }
            }
        }
    }

}