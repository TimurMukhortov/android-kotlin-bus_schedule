package com.example.timurmuhortov.dubnabus.data.repository.network

import com.example.timurmuhortov.dubnabus.domain.irepository.IScheduleNetworkRepository
import com.example.timurmuhortov.dubnabus.domain.network.ScheduleAPI
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
        private val retrofit: ScheduleAPI,
        private val networkErrorMapper: INetworkErrorMapper
) : IScheduleNetworkRepository {


    override fun loadSchedule() = retrofit.getSchedule()
            .subscribeOn(Schedulers.io())
            .onErrorResumeNext {
                Single.error(networkErrorMapper.map(it)) }
            .observeOn(AndroidSchedulers.mainThread())


}
