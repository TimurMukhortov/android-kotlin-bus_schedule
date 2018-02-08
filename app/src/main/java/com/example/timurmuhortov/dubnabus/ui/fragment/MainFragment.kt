package com.example.timurmuhortov.dubnabus.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.presentation.presenter.main.MainPresenter
import com.example.timurmuhortov.dubnabus.presentation.view.IMainView
import com.example.timurmuhortov.dubnabus.ui.base.BaseFragment
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 3:02
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class MainFragment : BaseFragment(), IMainView {

    private val mainTag = "MainFragment"

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter
    @ProvidePresenter
    fun providePresenter() = presenter

    private lateinit var unbinder: Unbinder

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_mainscreen, container, false)
                    .also {
                        unbinder = ButterKnife.bind(this@MainFragment, it)
                    }


    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    @OnClick(R.id.button_schedule)
    protected fun onButtonSchedule() {
        Log.i(mainTag, "Schedule!")
        presenter.onSchedule()
    }

    @OnClick(R.id.button_map)
    protected fun onButtonMap() {
        Log.i(mainTag, "Map!")
        presenter.onMap()
    }

    @OnClick(R.id.button_about)
    protected fun onButtonAbout() {
        Log.i(mainTag, "About!")
        presenter.onAbout()
    }
}