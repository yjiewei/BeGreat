/*
 * @author yangjiewei
 * @date 2020/11/16 10:07
 */
package interview.singleton;

/**
 * 前三个都是饿汉式 可能会造成资源浪费，但是安全
 * 接下来是懒汉式，资源利用率高
 *      1.构造器私有化
 *      2.提供get获得对象的方法，注意线程安全问题
 */
public class Singleton5 {
    private static Singleton5 INSTANCE;
    private Singleton5(){}
    public Singleton5 getINSTANCE(){

        // 虽然线程安全了，但是锁粒度大，效率低
        synchronized (Singleton5.class){
            if (INSTANCE != null){
                INSTANCE = new Singleton5();
            }
            return INSTANCE;
        }
    }
}
