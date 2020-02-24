# IOC_DI
经典的IOC应用 利用反射,注解 注入视图，控件，以及绑定事件

实现思路
1：在BaseActivity 的OnCreate中实现注入  view activity event
2：通过反射获取类上的注解，获取注解中的视图id，通过反射拿到setContentView 然后调用实现注入视图
3：通过反射获取所有属性，如果包含注入控件的注解，就反射拿到findViewById，然后注入控件
4：绑定事件
    1：反射获取activity所有方法
    2：如果有能拿到我们设置多态的注解，就说明这是一个事件的注解
    3：然后通过反射方法拿到控件id数组
    4：反射获取所有view
    5：动态代理事件 listener 调用activity的事件方法
    6: 反射调用设置事件监听的方法   完成