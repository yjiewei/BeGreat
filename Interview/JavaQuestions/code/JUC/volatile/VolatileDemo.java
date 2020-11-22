/*
 * @author yangjiewei
 * @date 2020/11/19 21:18
 */
package com.yjiewei.volatile_JMM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.验证volatile的可见性
 * 2.验证volatile不保证原子性 (多线程操作 i++ ，即使加了volatile也没用）
 *      三条指令，可能出现写丢失
 *      那怎么解决呢？
 *      1.synchronized 杀鸡用的宰牛刀
 *      2.原子类 AtomicInteger
 *
 * 3.禁止指令重排（多线程下编译器优化指令重排，指令并行的重排，内存系统的重排）
 *      数据依赖性、数据一致性
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();

//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+" come in ");
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            myData.add();
//            System.out.println(Thread.currentThread().getName()+" 更新number为60  ");
//        },"A").start();
//
//        while(myData.number == 0){
//            // 如果main线程和 A线程 的变量可以感知，那么主线程就会退出
//            // 问题是这里number变量改变后主线程根本不知道，没人通知，没有可见性
//            // number只要用volatile修饰立刻就线程变量可见
//        }
//        System.out.println(Thread.currentThread().getName()+" mission is over ");



        for (int i = 0; i < 20; i++){
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.add1();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        // main线程和gc线程
        while(Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " : " + myData.number);
        System.out.println(Thread.currentThread().getName() + " : " + myData.atomicInteger);
    }
}

class MyData{
    volatile int number = 0;
    public void add(){
        this.number = 60;
    }

    public void add1(){
        this.number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}
