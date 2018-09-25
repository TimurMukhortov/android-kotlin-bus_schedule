package com.example.timurmuhortov.dubnabus.engine.repository.assets


import com.example.timurmuhortov.dubnabus.engine.data.schedule.ScheduleModel
import com.example.timurmuhortov.dubnabus.engine.domain.irepository.IScheduleAssetRepository
import com.example.timurmuhortov.dubnabus.util.reader.IFileReader
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 23.02.2018
 * time: 20:29
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

class ScheduleAssetRepository @Inject constructor(
        private val fileReader: IFileReader
) : IScheduleAssetRepository {


    private inner class ScheduleTmp(val schedules: ScheduleModel)

    companion object {
        private const val SCHEDULE_FILE_LOCATION = "schedule.json"
    }

    override fun getBaseSchedule() = fileReader
            .readFromAsset(SCHEDULE_FILE_LOCATION, ScheduleTmp::class.java)
            .subscribeOn(Schedulers.io())
            .map { it.schedules }
            .observeOn(AndroidSchedulers.mainThread())
}