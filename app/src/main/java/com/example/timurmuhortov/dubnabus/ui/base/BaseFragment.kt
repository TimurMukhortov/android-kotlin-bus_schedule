package com.example.timurmuhortov.dubnabus.ui.base

import android.app.Activity
import android.content.Context
import android.os.Build
import com.arellomobile.mvp.MvpAppCompatFragment
import dagger.android.support.AndroidSupportInjection

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 3:02
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


abstract class BaseFragment : MvpAppCompatFragment() {

    override fun onAttach(context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }

    override fun onAttach(activity: Activity?){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(activity)
    }

}