package com.springjobhunting.designPattern.singleton;

/**
 * @author Rico_dds
 * @date 2021/5/15 9:45
 */
public class Singleton {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                System.out.println(SingleInstance.getInstance());
            }).start();
        }
    }

}
class SingleInstance{

    private static volatile SingleInstance instance;

    private SingleInstance(){}

    public  static SingleInstance getInstance(){
        if (instance == null){
            synchronized (SingleInstance.class){
                if (instance == null){
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }

}
