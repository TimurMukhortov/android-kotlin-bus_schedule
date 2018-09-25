package com.example.timurmuhortov.dubnabus.engine.repository.network

import com.example.timurmuhortov.dubnabus.DubnabusApplication
import com.example.timurmuhortov.dubnabus.engine.data.ConfigModel
import com.example.timurmuhortov.dubnabus.engine.data.schedule.ScheduleModel
import com.example.timurmuhortov.dubnabus.engine.domain.irepository.IScheduleNetworkRepository
import com.example.timurmuhortov.dubnabus.engine.domain.network.ScheduleAPI
import com.example.timurmuhortov.dubnabus.util.retrofit.INetworkErrorMapper
import com.example.timurmuhortov.dubnabus.util.retrofit.NetworkErrorMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
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

//    private val realmConfiguration = RealmConfiguration
//            .Builder()
//            .name("DubnaBus")
//            .deleteRealmIfMigrationNeeded()
//            .build()

    override fun checkVersion(): Single<Long> =
            retrofit.getVersionSchedule()
                    .subscribeOn(Schedulers.io())
                    .doOnError {
                        Single.error<NetworkErrorMapper>(networkErrorMapper.map(it))
                    }
                    .doOnSuccess {
//                        val realmInstance = Realm.getInstanceAsync()
//                        realmInstance.executeTransactionAsync { realm ->
//                            val configModel = realm
//                                    .where(ConfigModel::class.java)
//                                    .findFirst();
//                            configModel?.scheduleVersion = it
//                        }
                    }
                    .observeOn(AndroidSchedulers.mainThread())

    override fun updateSchedule(): Single<ScheduleModel> =
            retrofit.getUpdateSchedule()
                    .subscribeOn(Schedulers.io())
                    .doOnError {
                        Single.error<NetworkErrorMapper>(networkErrorMapper.map(it))
                    }
                    .doOnSuccess {
//                        val realmInstance = Realm.getInstance(realmConfiguration)
//                        realmInstance.executeTransactionAsync { realm ->
//                            realm
//                                    .where(ScheduleModel::class.java)
//                                    .findFirst()?.deleteFromRealm()
//                            realm.createObject<ScheduleModel>(it::class.java)
//                        }
                    }
                    .observeOn(AndroidSchedulers.mainThread())

}
