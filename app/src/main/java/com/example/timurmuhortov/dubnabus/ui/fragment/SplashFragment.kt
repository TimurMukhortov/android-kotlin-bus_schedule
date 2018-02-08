package com.example.timurmuhortov.dubnabus.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.presentation.view.ISplashView
import com.example.timurmuhortov.dubnabus.ui.base.BaseFragment

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 18:49
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class SplashFragment : BaseFragment(), ISplashView {

    private val splashTag = "SplashFragment"

    companion object {
        fun newInstance() = SplashFragment()
    }

    private lateinit var unbinder: Unbinder

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_splashscreen, container, false)
                    .also {
                        unbinder = ButterKnife.bind(this@SplashFragment, it)
                    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }
}