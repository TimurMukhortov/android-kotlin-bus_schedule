package com.example.timurmuhortov.dubnabus.data.repository

import com.example.timurmuhortov.dubnabus.data.entity.Time
import com.example.timurmuhortov.dubnabus.domain.IScheduleRepository
import com.example.timurmuhortov.dubnabus.util.reader.IFileReader
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:25
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleRepository @Inject constructor(
        private val fileReader: IFileReader
) : IScheduleRepository {
    private inner class Times(val times: List<Time>)

    companion object {

        private const val TIMES_FILE_LOCATION = "times.json"
    }

    override fun loadTimes() =
            fileReader.readFromAsset(TIMES_FILE_LOCATION, Times::class.java)
                    .subscribeOn(Schedulers.io())
                    .map { it.times }
                    .observeOn(AndroidSchedulers.mainThread())


}
