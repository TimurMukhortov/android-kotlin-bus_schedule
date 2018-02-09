package com.example.timurmuhortov.dubnabus.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.timurmuhortov.dubnabus.R
import com.example.timurmuhortov.dubnabus.presentation.routing.base.IRoutingBinder
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 2:55
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


abstract class SingleFragmentActivity: AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    protected lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    protected lateinit var routingBinder: IRoutingBinder

    abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_single_fragment)
        super.onCreate(savedInstanceState)

        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        if (fragment == null) {
            supportFragmentManager.
                    beginTransaction()
                    .replace(R.id.container, createFragment())
                    .commit()
        }
    }

    override fun onResume() {
        super.onResume()
        routingBinder.bind()
    }

    override fun onPause() {
        super.onPause()
        routingBinder.unbind()
    }

    override fun supportFragmentInjector() = fragmentInjector
}