package com.omega.ioc.di.annotation

import java.lang.annotation.ElementType

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class BindLayout(val layoutId:Int)