package com.omega.ioc.di.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@BIndEventByJava(methodName = "setOnClickListener",listenerClass = View.OnClickListener.class,eventName = "OnClick")
public @interface OnClickByJava {
  int[] value();
}
