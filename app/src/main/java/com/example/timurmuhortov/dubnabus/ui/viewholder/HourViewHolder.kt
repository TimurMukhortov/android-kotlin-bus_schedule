package com.example.timurmuhortov.dubnabus.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.data.ui.HourViewData

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 1:34
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class HourViewHolder(
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

    //    fun bind(data: Time1ViewData) {
//        hour.text = data.hour
//        minuteFirst.text = data.minuteFirst
//        minuteSecond.text = data.minuteSecond
//        minuteThird.text = data.minuteThird
//        minuteFourth.text = data.minuteFourth
//    }
    @Deprecated("необходимо поправить этот метод, если в списке автобусов меньше 4-ех " +
            "все упадет.")
    fun bind(data: HourViewData) {
        //TODO HourViewHolder
        // необходимо сделать динамическое создание виджетов
        // для отображеие минут
        hour.text = data.hour.toString()
        minuteFirst.text = if (data.minutes.size > 0) data.minutes[0].toString() else "-"
        minuteSecond.text = if (data.minutes.size > 1) data.minutes[1].toString() else "-"
        minuteThird.text = if (data.minutes.size > 2) data.minutes[2].toString() else "-"
        minuteFourth.text = if (data.minutes.size > 3) data.minutes[3].toString() else "-"
    }
}