package com.example.timurmuhortov.dubnabus.data.repository

import com.example.timurmuhortov.dubnabus.data.entity.Bus
import com.example.timurmuhortov.dubnabus.data.entity.Stop
import com.example.timurmuhortov.dubnabus.data.entity.Time
import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleRepository
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


class ScheduleRepository @Inject constructor(
        private val fileReader: IFileReader,
        private val retrofit: ScheduleAPI,
        private val networkErrorMapper: INetworkErrorMapper
) : IScheduleRepository {

    private inner class Times(val times: List<Time>)

    companion object {
        private const val TIMES_FILE_LOCATION = "times.json"
    }

    override fun loadNetworkSchedule() = retrofit.getSchedule()
            .subscribeOn(Schedulers.io())
            .onErrorResumeNext {
                Single.error(networkErrorMapper.map(it)) }
            .observeOn(AndroidSchedulers.mainThread())

    override fun loadStopsDataBase() =
            fileReader.readFromAsset(TIMES_FILE_LOCATION, Times::class.java)
                    .subscribeOn(Schedulers.io())
                    .map { it.times }
                    .observeOn(AndroidSchedulers.mainThread())

    override fun loadStopsNetwork(): Single<List<Stop>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadDefaultBuses(): Single<List<Bus>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBuses(): Single<List<Bus>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
