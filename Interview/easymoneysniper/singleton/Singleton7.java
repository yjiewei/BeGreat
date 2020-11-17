/*
 * @author yangjiewei
 * @date 2020/11/16 10:07
 */
package interview.singleton;

/**
 * 前三个都是饿汉式 可能会造成资源浪费，但是安全
 *
 * 静态内部类的方式实现
 * 接下来是懒汉式，资源利用率高
 *      1.构造器私有化
 *      2.提供get获得对象的方法，注意线程安全问题
 *
 *  在内部类被加载时创建对象，而且只加载一次，且使用的时候才加载，单独加载初始化
 */
public class Singleton7 {

    private Singleton7(){}

    private static class Inner{
        private static Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return Inner.INSTANCE;
    }

}
