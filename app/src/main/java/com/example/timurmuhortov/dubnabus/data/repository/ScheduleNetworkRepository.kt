package com.example.timurmuhortov.dubnabus.data.repository

import com.example.timurmuhortov.dubnabus.data.entity.Bus
import com.example.timurmuhortov.dubnabus.data.entity.Stop
import com.example.timurmuhortov.dubnabus.data.entity.Time
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleNetworkRepository
import com.example.timurmuhortov.dubnabus.domain.network.ScheduleAPI
import com.example.timurmuhortov.dubnabus.util.reader.IFileReader
import com.example.timurmuhortov.dubnabus.util.retrofit.INetworkErrorMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 14.02.2018
 * time: 21:25
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


class ScheduleNetworkRepository @Inject constructor(
        private val fileReader: IFileReader,
        private val retrofit: ScheduleAPI,
        private val networkErrorMapper: INetworkErrorMapper
) : IScheduleNetworkRepository {

    private inner class Times(val times: List<Time>)

    companion object {
        private const val TIMES_FILE_LOCATION = "times.json"
    }

    override fun loadStopsDataBase() =
            fileReader.readFromAsset(TIMES_FILE_LOCATION, Times::class.java)
                    .subscribeOn(Schedulers.io())
                    .map { it.times }
                    .observeOn(AndroidSchedulers.mainThread())

    override fun loadSchedule() = retrofit.getSchedule()
            .subscribeOn(Schedulers.io())
            .onErrorResumeNext {
                Single.error(networkErrorMapper.map(it)) }
            .observeOn(AndroidSchedulers.mainThread())


}
