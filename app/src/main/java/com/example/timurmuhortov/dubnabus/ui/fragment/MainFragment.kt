package com.example.timurmuhortov.dubnabus.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.timurmuhortov.dubnabus.R

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 3:02
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class MainFragment: Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.activity_main, container, false)
}