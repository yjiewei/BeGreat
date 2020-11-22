/*
 * @author yangjiewei
 * @date 2020/11/21 18:49
 */
package com.yjiewei.volatile_JMM;

/**
 * instance = new SingletonDemo();
 * 会分成三步：
 *      1.分配对象内存空间
 *      2.初始化对象
 *      3.设置instance指向刚分配的内存地址 此时instance != null
 *      但是如果2、3指令重排，会导致对象没有初始化完成
 */
public class SingletonDemo {

    // 有很小的机会会出现指令重排的情况导致出错，所以这里加一个volatile
    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"我是构造方法");
    }

    // 1.你可以在方法上加一个同步方法
    // 2.DCL 双重检查锁
    public static SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        // main线程的操作下没问题 这里不写
        // 并发多线程下就不一样啦
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
