package com.example.timurmuhortov.dubnabus.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.data.ScheduleViewData

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 1:34
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleViewHolder(
        inflater: LayoutInflater,
        container: ViewGroup
) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_schedule, container, false)) {

    @BindView(R.id.textView_hour)
    lateinit var hour: TextView

    @BindView(R.id.textView_minute_first)
    lateinit var minuteFirst: TextView

    @BindView(R.id.textView_minute_second)
    lateinit var minuteSecond: TextView

    @BindView(R.id.textView_minute_third)
    lateinit var minuteThird: TextView

    @BindView(R.id.textView_minute_fourth)
    lateinit var minuteFourth: TextView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun bind(data: ScheduleViewData) {
        hour.text = data.hour
        minuteFirst.text = data.minuteFirst
        minuteSecond.text = data.minuteSecond
        minuteThird.text = data.minuteThird
        minuteFourth.text = data.minuteFourth
    }
}