package com.example.timurmuhortov.dubnabus.engine.di.scope

import javax.inject.Scope

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 2:24
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/


@Scope
   /*
    *
    * Аннотация @Retention позволяет указать,
    * в какой момент жизни программного кода
    * будет доступна аннотация:
    *   только в исходном коде,
    *   в скомпилированном классе
    *   или во время выполнения программы.
    *
    *   SOURCE - аннотация доступна только в исходном коде и сбрасывается во время создания .class файла;
    *
    *   CLASS - аннотация хранится в .class файле, но недоступна во время выполнения программы;
    *
    *   RUNTIME - аннотация хранится в .class файле и доступна во время выполнения программы.
    *
    * Все эти аннотации являются элементами перечисления java.lang.annotation.RetentionPolicy.
    *
    */
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope