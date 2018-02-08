package com.example.timurmuhortov.dubnabus.ui.activity

import android.content.Context
import android.content.Intent
import com.example.timurmuhortov.dubnabus.ui.base.SingleFragmentActivity
import com.example.timurmuhortov.dubnabus.ui.fragment.SplashFragment

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 19:12
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class SplashActivity : SingleFragmentActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, SplashActivity::class.java)
    }

    override fun createFragment() = SplashFragment.newInstance()
}