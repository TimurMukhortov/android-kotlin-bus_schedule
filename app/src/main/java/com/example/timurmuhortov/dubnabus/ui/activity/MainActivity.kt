package com.example.timurmuhortov.dubnabus.ui.activity

import android.content.Context
import android.content.Intent
import com.example.timurmuhortov.dubnabus.di.base.SingleFragmentActivity
import com.example.timurmuhortov.dubnabus.ui.fragment.MainFragment

class MainActivity : SingleFragmentActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun createFragment() = MainFragment.newInstance()

}
