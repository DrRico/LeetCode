package com.rico.easy;

/**
 * @author Rico_dds
 * @date 2020/9/12 22:43
 */


// 懒汉式单例模式

// 只有当你需要的时候才去创建

public class SingletonLazyMan {
    private SingletonLazyMan(){}

    private volatile static SingletonLazyMan singletonLazyMan;

    public static SingletonLazyMan getInstance(){
        if (singletonLazyMan == null){
            synchronized (SingletonLazyMan.class){
                if (singletonLazyMan == null){
                    singletonLazyMan = new SingletonLazyMan();
                    /*
                    * 1、分配内存空间
                    * 2、执行构造方法、初始化对象
                    * 3、把这个对象指向这个空间
                    *
                    * 如 1 2 3
                    * 可能由于指令重排导致1 3 2
                    *
                    * 为了保证多线程下的安全。需要在单例前面加上  volatile  关键字即可
                    *
                    * */
                }
            }
        }
        return singletonLazyMan;
    }

}
