package com.omega.ioc.di

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import com.omega.ioc.di.annotation.BindLayout
import com.omega.ioc.di.annotation.BindView

object  ActivityInject {
    fun inject(context:Activity){
      //实现布局文件的注入
        injectLayout(context)
        injectView(context)
        

    }



    /**
     * @param context 用来反射获取setContentView方法
     */
    fun injectLayout(context:Activity){
        val declaredMethod = context.javaClass.getMethod("setContentView", Int::class.java)
        val javaClass = context.javaClass
        val annotation = javaClass.getAnnotation(BindLayout::class.java)
        declaredMethod.invoke(context,annotation?.layoutId)
    }

    fun injectView(context:Activity){
        val javaClass = context.javaClass
        val method = javaClass.getMethod("findViewById", Int::class.java)
        val declaredFields = javaClass.declaredFields
        for (field in declaredFields){
            val annotation = field.getAnnotation(BindView::class.java)
            if (annotation!=null){
                val view = method.invoke(context, annotation.layoutId)
                field.isAccessible=true
                field.set(context,view)
            }
        }
    }
}