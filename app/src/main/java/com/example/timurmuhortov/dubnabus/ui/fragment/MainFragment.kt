package com.example.timurmuhortov.dubnabus.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.extension.setCenterTitle
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

    companion object {

        fun newInstance() = MainFragment()
    }
    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @BindView(R.id.toolbar)
    protected lateinit var toolbar: Toolbar

    @ProvidePresenter
    fun providePresenter() = presenter
    private lateinit var unbinder: Unbinder

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main, container, false)
                    .also {
                        unbinder = ButterKnife.bind(this@MainFragment, it)
                        toolbar.setCenterTitle("РАСПИСАНИЕ АВТОБУСОВ \n г. Дубна")
                    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }


    override fun createAlertDialog(title: String, msg: String) = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton("OK", {button,_  -> button.dismiss()})
            .create()
            .show()

    @OnClick(R.id.button_schedule)
    protected fun onButtonSchedule() {
        presenter.onSchedule()
    }

    @OnClick(R.id.button_map)
    protected fun onButtonMap() {
        presenter.onMap()
    }

    @OnClick(R.id.button_about)
    protected fun onButtonAbout() {
        presenter.onAbout()
    }
}