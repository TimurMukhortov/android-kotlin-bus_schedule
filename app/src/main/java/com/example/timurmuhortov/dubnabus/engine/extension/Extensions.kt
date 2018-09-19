package com.example.timurmuhortov.dubnabus.engine.extension

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.example.timurmuhortov.dubnabus.DubnabusApplication
import com.example.timurmuhortov.dubnabus.R

/**
 * @author: timur.mukhortov
 * date: 09.02.2018
 * time: 3:54
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


fun Toolbar.setCenterTitle(title: String) {
    val textTitle = getChildAt(0) as? TextView
    textTitle?.text = title
}

fun Fragment.setSupportActionBar(toolbar: android.support.v7.widget.Toolbar) {
    val hostedActivity = activity as? AppCompatActivity
    hostedActivity?.setSupportActionBar(toolbar)
}

fun Fragment.getSupportActionBar(): ActionBar? {
    val hostedActivity = activity as? AppCompatActivity
    return hostedActivity?.supportActionBar
}

@SuppressLint("ResourceType")
fun convertResColorToIntColor(@ColorRes color: Int): Int {
    val strColor = getString(color)
    return Color.parseColor(strColor)
}

fun Fragment.prepareToolbar(toolbar: Toolbar,
                            @ColorRes toolbarColor: Int = R.color.colorBlack_60per,
                            visibility: Int = View.VISIBLE,
                            block: ((View) -> Unit)? = null) {
    setSupportActionBar(toolbar)
    getSupportActionBar()?.setDisplayShowTitleEnabled(false)
    toolbar.visibility = visibility

    val parentView = toolbar.parent as? View
    parentView?.setBackgroundColor(convertResColorToIntColor(toolbarColor))

    block?.let {
        this.getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener(block)
    }
}

fun getString(@StringRes id: Int): String = DubnabusApplication.instance.getString(id)

fun getColor(@ColorRes id: Int): Int = ContextCompat.getColor(DubnabusApplication.instance, id)