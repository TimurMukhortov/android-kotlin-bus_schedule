package com.example.timurmuhortov.dubnabus.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.engine.data.schedule.HourModel
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

    fun bind(hourModel: HourModel) {
        // необходимо сделать один recycler
        // для отображеие минут
        hour.text = hourModel.hour.toString()
    }
}