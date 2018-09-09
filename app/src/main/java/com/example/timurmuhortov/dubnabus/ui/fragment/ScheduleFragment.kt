package com.example.timurmuhortov.dubnabus.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.data.entity.database.StopDB
import com.example.timurmuhortov.dubnabus.data.ui.BusViewData
import com.example.timurmuhortov.dubnabus.data.ui.HourViewData
import com.example.timurmuhortov.dubnabus.extension.prepareToolbar
import com.example.timurmuhortov.dubnabus.extension.setCenterTitle
import com.example.timurmuhortov.dubnabus.presentation.presenter.schedule.SchedulePresenter
import com.example.timurmuhortov.dubnabus.presentation.view.IScheduleView
import com.example.timurmuhortov.dubnabus.ui.base.BaseFragment
import com.example.timurmuhortov.dubnabus.util.adapter.BusAdapter
import com.example.timurmuhortov.dubnabus.util.adapter.DayAdapter
import com.example.timurmuhortov.dubnabus.util.adapter.ScheduleAdapter
import com.example.timurmuhortov.dubnabus.util.adapter.StopAdapter
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.partial_toolbar.*
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

    @Inject
    protected lateinit var adapterStop: StopAdapter

    @Inject
    protected lateinit var adapterBus: BusAdapter

    @Inject
    protected lateinit var adapterDay: DayAdapter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_schedule, container, false)
                    .also {
                        prepareToolbar(toolbar, R.color.colorTransparent) {
                            presenter.onBack()
                        }
                        toolbar.setCenterTitle("Расписание")

                        spinner_schedule_station.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                                presenter.getBusesForStop(adapterStop.getStopId(position))
                            }

                            override fun onNothingSelected(parent: AdapterView<*>) {}
                        })

                        spinner_schedule_day_of_week.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                                presenter.getBusesForStopByDay(adapterDay.getDayId(position))
                            }

                            override fun onNothingSelected(parent: AdapterView<*>) {}
                        })

                        spinner_schedule_number_bus.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                            override fun onNothingSelected(parent: AdapterView<*>?) {

                            }

                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                presenter.getSheduleForBus(adapterBus.getBusId(position))
                            }

                        })

                        recyclerView_schedule.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        recyclerView_schedule.adapter = adapterSchedule

                    }

    override fun showHours(times: List<HourViewData>) {
        adapterSchedule.schedules = times
    }

    override fun showStopName(stops: List<StopDB>) {
        adapterStop.setStops(stops)
        spinner_schedule_station.setAdapter(ArrayAdapter(this.context, android.R.layout.simple_spinner_item, stops))
        spinner_schedule_day_of_week.setAdapter(ArrayAdapter(this.context, android.R.layout.simple_spinner_item, adapterDay.getDays()))
    }

    override fun showBusName(buses: List<BusViewData>) {
        adapterBus.setBuses(buses)
        spinner_schedule_number_bus.setAdapter(ArrayAdapter(this.context, android.R.layout.simple_spinner_item, buses))
    }

    override fun showAlertDialog(title: String, message: String) = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { button, _ -> button.dismiss() }
            .create()
            .show()

}
