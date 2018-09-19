package com.example.timurmuhortov.dubnabus.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.presentation.presenter.splash.SplashPresenter
import com.example.timurmuhortov.dubnabus.presentation.view.ISplashView
import com.example.timurmuhortov.dubnabus.ui.base.BaseFragment
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 08.02.2018
 * time: 18:49
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class SplashFragment : BaseFragment(), ISplashView {

    companion object {
        fun newInstance() = SplashFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter
    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_splash, container, false)

}