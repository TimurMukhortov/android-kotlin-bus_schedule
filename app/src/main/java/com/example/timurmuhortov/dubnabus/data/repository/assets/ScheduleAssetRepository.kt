package com.example.timurmuhortov.dubnabus.data.repository.assets


import com.example.timurmuhortov.dubnabus.data.entity.Schedule
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleAssetRepository
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

@Deprecated("Сейчас файл schedule.json содержит всего две остановки, потом заменить на полный файл.")
class ScheduleAssetRepository @Inject constructor(
        private val fileReader: IFileReader
) : IScheduleAssetRepository {


    private inner class ScheduleTmp(val schedules: Schedule)

    companion object {
        private const val SCHEDULE_FILE_LOCATION = "schedule.json"
    }

    override fun loadSchedule() = fileReader
            .readFromAsset(SCHEDULE_FILE_LOCATION, ScheduleTmp::class.java)
            .subscribeOn(Schedulers.io())
            .map { it.schedules }
            .observeOn(AndroidSchedulers.mainThread())
}