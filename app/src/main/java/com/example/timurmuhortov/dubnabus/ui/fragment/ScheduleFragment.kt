package com.example.timurmuhortov.dubnabus.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.extension.prepareToolbar
import com.example.timurmuhortov.dubnabus.extension.setCenterTitle
import com.example.timurmuhortov.dubnabus.presentation.presenter.schedule.SchedulePresenter
import com.example.timurmuhortov.dubnabus.presentation.view.IScheduleView
import com.example.timurmuhortov.dubnabus.ui.base.BaseFragment
import com.example.timurmuhortov.dubnabus.util.ScheduleAdapter
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 09.02.2018
 * time: 4:19
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleFragment : BaseFragment(), IScheduleView {

    companion object {
        fun newInstance() = ScheduleFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: SchedulePresenter

    @Inject
    protected lateinit var adapterSchedule: ScheduleAdapter

    @ProvidePresenter
    fun providePresenter() = presenter

    @BindView(R.id.toolbar)
    protected lateinit var toolbar: Toolbar

    @BindView(R.id.recyclerView_schedule)
    lateinit var recyclerViewSchedule: RecyclerView

    private lateinit var unbinder: Unbinder

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_schedule, container, false)
                    .also {
                        unbinder = ButterKnife.bind(this@ScheduleFragment, it)

                        prepareToolbar(toolbar, R.color.colorTransparent) {
                            presenter.onBack()
                        }
                        toolbar.setCenterTitle("Расписание")

                        recyclerViewSchedule.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        recyclerViewSchedule.adapter = adapterSchedule
                    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }
}