package com.jingchu.reflex;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 反射学习
 * @author: JingChu
 * @createtime :2020-07-29 10:07:17
 **/
public class MyReflex {
    /**
     * 在使用反射之前我们可以做哪些事
     */
    @Test
    public void test() {
        //新建一个User对象，这里只能看到两个共有的构造方法
        User user = new User("景初", 18);
        //通过user对象调用内部的方法和属性
        user.age = 20;
        System.out.println(user.toString());
        user.show();

    }

    /**
     * 使用反射做到的事
     */
    @Test
    public void test2() throws Exception {
        //1。使用反射创建对象

        Class clazz = User.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        //可以使用Object接收，也可以类型强转，效果类似
        System.out.println("-------------------->:使用反射创建对象");
        Object object = constructor.newInstance("景初", 18);
        User user = (User) object;
        System.out.println("object接收的对象：\t" + object.toString());
        System.out.println("user接收的对象：\t" + user.toString());

        //2。通过反射调用对象指定的属性和方法
        System.out.println("-------------------->:使用反射调用对象的属性和方法");
        //获得age属性
        Field age = clazz.getDeclaredField("age");
        //将user对象的age值改为20
        age.set(user, 20);
        age.set(object, 10);
        System.out.println("更改属性后的user对象\t" + user);
        System.out.println("更改属性后的object对象\t" + user);
        Method show = clazz.getDeclaredMethod("show");
        System.out.println("object调用show方法：\t");
        show.invoke(object);
        System.out.println("user调用showNation方法：\t");
        show.invoke(user);

        //3.通过反射调用私有的构造器，私有的方法，私有的属性
        System.out.println("-------------------->:使用反射调用对象私有的属性、方法、构造器");
        //调用一个参数的私有方法
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        User user1 = (User) constructor1.newInstance("JingCHu");
        System.out.println("调用私有构造器生成的user对象：\t" + user1);
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user1,"JingChu也是景初");
        System.out.println("更改私有属性name后的user对象：\t" + user1);
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        System.out.println("调用user对象的私有方法：\t" +showNation.invoke(user1,"中国"));

    }
}
