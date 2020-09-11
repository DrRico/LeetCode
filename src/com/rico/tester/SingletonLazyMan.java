package com.rico.tester;

/**
 * @author Rico_dds
 * @date 2020/9/10 16:29
 */
public class SingletonLazyMan {
    private SingletonLazyMan(){
        System.out.println(Thread.currentThread().getName() + " ok");
    }

    private volatile static SingletonLazyMan singletonLazyMan;

    public static SingletonLazyMan getInstance(){
        //枷锁
        if (singletonLazyMan == null){
            synchronized (SingletonLazyMan.class){
                if (singletonLazyMan == null){
                    singletonLazyMan = new SingletonLazyMan();
                }
            }
        }

        if (singletonLazyMan == null){
            singletonLazyMan = new SingletonLazyMan();
        }
        return  singletonLazyMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                singletonLazyMan.getInstance();
            }).start();
        }
    }


}
