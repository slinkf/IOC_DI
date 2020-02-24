package com.omega.ioc.di.proxy

import android.util.Log
import android.view.View
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class EventInvocationHandler(var method: Method,var obj:Any):InvocationHandler {
    /**
     * p0代理类真实的代理对象  xxx$Proxy
     * p1 执行的方法
     * p2 参数
     */
    override fun invoke(p0: Any?, p1: Method?, p2: Array<out Any>?): Any? {  //反射还是用JAVA写吧，这里并不能兼容那么多事件  下面p2用了硬编码
        method.isAccessible = true
        method.invoke(obj,p2!![0]) //一点就崩溃的问题
       return null
    }
}