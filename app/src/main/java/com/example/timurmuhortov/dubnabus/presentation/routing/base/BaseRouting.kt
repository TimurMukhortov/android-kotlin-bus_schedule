package com.example.timurmuhortov.dubnabus.presentation.routing.base

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDialogFragment
import com.example.timurmuhortov.dubnabus.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.commands.Command

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 21:11
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


abstract class BaseRouting<out T: AppCompatActivity>(
        protected val activity: T,
        private val navigationHolder: NavigatorHolder
): IRoutingBinder {

    private val fragmentManager
        get() = activity.supportFragmentManager

    private val navigator = Navigator {
        recognizeCommand(it)
    }

    override fun bind() {
        navigationHolder.setNavigator(navigator)
    }

    override fun unbind() {
        navigationHolder.removeNavigator()
    }

    abstract fun recognizeCommand(command: Command)

    protected fun openActivity(intent: Intent) {
        activity.startActivity(intent)
    }

    protected fun replaceActivity(intent: Intent) {
        activity.startActivity(intent)
        activity.finish()
    }

    protected fun openFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = fragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    /**
     * Pops a fragment back
     * return true if fragment was popped, false otherwise
     */
    protected fun popFragment() = (fragmentManager.fragments.size > 0).also {
        fragmentManager.popBackStack()
    }

    @SuppressLint("CommitTransaction")
    protected fun openDialogFragment(fragment: AppCompatDialogFragment, tag: String = "dialog") {
        fragment.show(fragmentManager.beginTransaction().addToBackStack(null), tag)
    }

    protected fun popFragmentBack() =
            (fragmentManager.fragments.size > 0).also { fragmentManager.popBackStack() }

}