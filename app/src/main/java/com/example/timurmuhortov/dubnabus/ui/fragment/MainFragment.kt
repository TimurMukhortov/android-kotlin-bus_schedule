package com.example.timurmuhortov.dubnabus.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.di.base.BaseFragment
import dagger.android.support.AndroidSupportInjection

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 3:02
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class MainFragment: BaseFragment() {

    companion object {
        fun newInstance(): Fragment = MainFragment.newInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.activity_main, container, false)
}