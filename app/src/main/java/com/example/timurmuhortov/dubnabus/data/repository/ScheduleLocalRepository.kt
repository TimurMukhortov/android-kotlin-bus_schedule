package com.example.timurmuhortov.dubnabus.data.repository


import com.example.timurmuhortov.dubnabus.data.entity.Schedule
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleLocalRepository
import com.example.timurmuhortov.dubnabus.util.reader.IFileReader
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 23.02.2018
 * time: 20:29
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleLocalRepository @Inject constructor(
        private val fileReader: IFileReader
) : IScheduleLocalRepository {


    private inner class Hours(val times: List<Schedule>)

    companion object {
        private const val TIMES_FILE_LOCATION = "times.json"
    }

    override fun loadSchedule(): Single<Schedule> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}