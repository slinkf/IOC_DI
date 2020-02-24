package com.omega.ioc.di.proxy;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import com.omega.ioc.di.R;
import com.omega.ioc.di.annotation.BIndEventByJava;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ActivityInjectByJava {
    public static void injectEvent(Activity activitiy){
        Class<? extends Activity> activitiyClass = activitiy.getClass();
        Method[] activitiyClassDeclaredMethods =
                activitiyClass.getDeclaredMethods();
        for (Method activityMethod:activitiyClassDeclaredMethods) {
            Annotation[] activityMethodAnnotations = activityMethod.getAnnotations();
            for (Annotation activityMethodAnnotation:activityMethodAnnotations) {
                Class<? extends Annotation> annotationClass = activityMethodAnnotation.annotationType();
                BIndEventByJava eventAnnotation = annotationClass.getAnnotation(BIndEventByJava.class);
                if (eventAnnotation!=null){
                    Class<?> listenerAnnotationClass = eventAnnotation.listenerClass();
                    String listenerMethodName = eventAnnotation.methodName();
                    try {
                        Method method = activityMethodAnnotation.getClass().getDeclaredMethod("value");
                        int[] viewArr = (int[]) method.invoke(activityMethodAnnotation);
                        //这里改为通过反射获取id，然后拿到遍历id循环设置事件
                        Method findViewByIdMethod = activitiyClass.getMethod("findViewById", int.class);
                        for (int id:viewArr) {
                            Object view =  findViewByIdMethod.invoke(activitiy, id);
                            //获取方法
                            //Method declaredMethod = viewById.getClass().getDeclaredMethod(s, aClass2);
                            //动态代理onClick方法
                            EventInvocationHandler eventInvocationHandler = new EventInvocationHandler(activityMethod,activitiy);
                            //代理得到的OnClickListener实例
                            Object listener = Proxy.newProxyInstance(view.getClass().getClassLoader(),new Class[]{listenerAnnotationClass}, eventInvocationHandler);
                            Method eventMethod = view.getClass().getMethod(listenerMethodName, listenerAnnotationClass);
                            eventMethod.invoke(view,listener);
                            //找到所有的view,然后依次设置事件
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(activitiy, "error"+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }
            }
        }
    }


}
