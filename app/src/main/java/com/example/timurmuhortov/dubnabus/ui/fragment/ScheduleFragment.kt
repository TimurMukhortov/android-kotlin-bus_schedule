package com.example.timurmuhortov.dubnabus.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.data.entity.database.StopDB
import com.example.timurmuhortov.dubnabus.data.ui.BusViewData
import com.example.timurmuhortov.dubnabus.data.ui.HourViewData
import com.example.timurmuhortov.dubnabus.data.ui.StopViewData
import com.example.timurmuhortov.dubnabus.extension.prepareToolbar
import com.example.timurmuhortov.dubnabus.extension.setCenterTitle
import com.example.timurmuhortov.dubnabus.presentation.presenter.schedule.SchedulePresenter
import com.example.timurmuhortov.dubnabus.presentation.view.IScheduleView
import com.example.timurmuhortov.dubnabus.ui.base.BaseFragment
import com.example.timurmuhortov.dubnabus.util.adapter.BusAdapter
import com.example.timurmuhortov.dubnabus.util.adapter.DayAdapter
import com.example.timurmuhortov.dubnabus.util.adapter.ScheduleAdapter
import com.example.timurmuhortov.dubnabus.util.adapter.StopAdapter
import org.angmarch.views.NiceSpinner
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

    @BindView(R.id.toolbar)
    protected lateinit var toolbar: Toolbar

    @BindView(R.id.spinner_nameStop)
    protected lateinit var spinnerStop: NiceSpinner

    @BindView(R.id.spinner_nameBus)
    protected lateinit var spinnerBus: NiceSpinner

    @BindView(R.id.spinner_dayOfWeek)
    protected lateinit var spinnerDay: NiceSpinner

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

                        spinnerStop.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                                presenter.getBusesForStop(adapterStop.getStopId(position))
                            }

                            override fun onNothingSelected(parent: AdapterView<*>) {}
                        })

                        spinnerDay.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                                presenter.getBusesForStopByDay(adapterDay.getDayId(position))
                            }

                            override fun onNothingSelected(parent: AdapterView<*>) {}
                        })

                        spinnerBus.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                            override fun onNothingSelected(parent: AdapterView<*>?) {

                            }

                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                presenter.getSheduleForBus(adapterBus.getBusId(position))
                            }

                        })

                        recyclerViewSchedule.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        recyclerViewSchedule.adapter = adapterSchedule

                    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    override fun showHours(times: List<HourViewData>) {
        adapterSchedule.schedules = times
    }

    override fun showStopName(stops: List<StopDB>) {
        adapterStop.setStops(stops)
        spinnerStop.setAdapter(ArrayAdapter(this.context, android.R.layout.simple_spinner_item, stops))
        spinnerDay.setAdapter(ArrayAdapter(this.context, android.R.layout.simple_spinner_item, adapterDay.getDays()))
    }

    override fun showBusName(buses: List<BusViewData>) {
        adapterBus.setBuses(buses)
        spinnerBus.setAdapter(ArrayAdapter(this.context, android.R.layout.simple_spinner_item, buses))
    }

    override fun showAlertDialog(title: String, message: String) = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { button, _ -> button.dismiss() }
            .create()
            .show()

}
