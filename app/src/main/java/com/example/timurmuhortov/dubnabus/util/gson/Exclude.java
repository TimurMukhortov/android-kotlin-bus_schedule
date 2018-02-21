package com.example.timurmuhortov.dubnabus.util.gson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: timur.mukhortov
 * date: 20.02.2018
 * time: 23:35
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Exclude {
}