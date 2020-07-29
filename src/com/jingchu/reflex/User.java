package com.jingchu.reflex;


/**
 * @description: 测试使用用户类
 * @author: JingChu
 * @createtime :2020-07-29 10:47:01
 **/

public class User {
    private String name;
    public int age;

    /**
     * 共有空参数构造器
     */
    public User() {
    }

    /**
     * 全参共有构造器
     *
     * @param name
     * @param age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 只有name参数的私有构造器
     *
     * @param name
     */
    private User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 共有方法
     */
    public void show() {
        System.out.println("我是：" + name + "\t 一个编程界的小学生");
    }

    /**
     * 私有方法
     * @param nation 国籍
     * @return
     */
    private String showNation(String nation) {
        return "我是" + nation + "人，我骄傲我自豪";
    }
}
