package com.rico.tester;

import java.util.concurrent.TimeUnit;

/**
 * @author Rico_dds
 * @date 2020/9/7 20:46
 *
 * 死锁测试
 */

public class DeadLockTest01 {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    private void deadLock(){
        Thread threadA = new Thread(()->{
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName() + "获得A成功");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获得B");
                    synchronized (lockB){
                        System.out.println(Thread.currentThread().getName() + "获得B成功");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread threadB = new Thread(()->{
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "获得B成功");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获得A");
                    synchronized (lockA){
                        System.out.println(Thread.currentThread().getName() + "获得A成功");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        DeadLockTest01 deadLockTest01 = new DeadLockTest01();
        deadLockTest01.deadLock();
    }
}
