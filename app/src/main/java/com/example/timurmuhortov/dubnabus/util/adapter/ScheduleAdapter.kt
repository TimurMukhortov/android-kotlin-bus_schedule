package com.example.timurmuhortov.dubnabus.util.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.timurmuhortov.dubnabus.data.ui.HourViewData
import com.example.timurmuhortov.dubnabus.di.scope.FragmentScope
import com.example.timurmuhortov.dubnabus.ui.viewholder.HourViewHolder
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 1:57
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@FragmentScope
class ScheduleAdapter @Inject constructor() : RecyclerView.Adapter<HourViewHolder>() {

    var schedules: List<HourViewData>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourViewHolder = HourViewHolder(LayoutInflater.from(parent.context), parent)

    override fun getItemCount(): Int = schedules?.size ?: 0

    override fun onBindViewHolder(holder: HourViewHolder?, position: Int) {
        schedules?.get(position)?.let {
            holder?.bind(it)
        }
    }

}