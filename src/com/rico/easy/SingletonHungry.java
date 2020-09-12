package com.rico.easy;

/**
 * @author Rico_dds
 * @date 2020/9/12 22:49
 */

// 饿汉式单例

// 就是当你无论需不需都会加载
public class SingletonHungry {

    private  SingletonHungry(){}

    private final static SingletonHungry SINGLETON_HUNGRY = new SingletonHungry();

    public static SingletonHungry getInstance(){

        return SINGLETON_HUNGRY;

    }


}
