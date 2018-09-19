package com.example.timurmuhortov.dubnabus.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.engine.extension.setCenterTitle
import com.example.timurmuhortov.dubnabus.presentation.presenter.main.MainPresenter
import com.example.timurmuhortov.dubnabus.presentation.view.IMainView
import com.example.timurmuhortov.dubnabus.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.partial_toolbar.*
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 3:02
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class MainFragment : BaseFragment(), IMainView, View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main, container, false)

    override fun createAlertDialog(title: String, msg: String) = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton(getString(R.string.ok)) { button, _ -> button.dismiss() }
            .create()
            .show()

    override fun onClick(v: View?) {
        when (v) {
            button_schedule -> {
                presenter.onSchedule()
            }
            button_map -> {
                presenter.onMap()
            }
            button_about -> {
                presenter.onAbout()
            }
        }
    }

}