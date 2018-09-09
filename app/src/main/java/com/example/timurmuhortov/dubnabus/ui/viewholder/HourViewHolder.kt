package com.example.timurmuhortov.dubnabus.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.data.ui.HourViewData
import kotlinx.android.synthetic.main.item_schedule.view.*

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

    private val hour = itemView.textView_item_schedule_hour
    private val minuteFirst = itemView.textView_item_schedule_minute_first
    private val minuteSecond = itemView.textView_item_schedule_minute_second
    private val minuteThird = itemView.textView_item_schedule_minute_third
    private val minuteFourth = itemView.textView_item_schedule_minute_fourth


    @Deprecated("необходимо поправить этот метод, если в списке автобусов меньше 4-ех " +
            "все упадет.")
    fun bind(data: HourViewData) {
        //TODO HourViewHolder
        // необходимо сделать один recycler
        // для отображеие минут
        hour.text = data.hour.toString()
        minuteFirst.text = if (data.minutes.isNotEmpty()) data.minutes[0].toString() else "-"
        minuteSecond.text = if (data.minutes.size > 1) data.minutes[1].toString() else "-"
        minuteThird.text = if (data.minutes.size > 2) data.minutes[2].toString() else "-"
        minuteFourth.text = if (data.minutes.size > 3) data.minutes[3].toString() else "-"
    }
}