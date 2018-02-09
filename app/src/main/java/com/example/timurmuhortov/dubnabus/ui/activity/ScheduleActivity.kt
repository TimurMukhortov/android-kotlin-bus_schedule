package com.example.timurmuhortov.dubnabus.ui.activity

import android.content.Context
import android.content.Intent
import com.example.timurmuhortov.dubnabus.ui.base.SingleFragmentActivity
import com.example.timurmuhortov.dubnabus.ui.fragment.ScheduleFragment

/**
 * @author: timur.mukhortov
 * date: 09.02.2018
 * time: 4:31
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleActivity: SingleFragmentActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, ScheduleActivity::class.java)
    }

    override fun createFragment() = ScheduleFragment.newInstance()
}