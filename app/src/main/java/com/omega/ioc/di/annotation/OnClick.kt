package com.omega.ioc.di.annotation

import android.view.View

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@BIndEventByJava(methodName = "setOnClickListener",listenerClass = View.OnClickListener::class,eventName = "OnClick")
annotation class OnClick(val id:Int)