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
public class Singleton4 {
    static Singleton4 INSTANCE;
    private Singleton4(){}
    public Singleton4 getINSTANCE(){

        // 但是这里如果多线程访问可能会出现线程不安全。适合单线程
        if (INSTANCE != null){
            INSTANCE = new Singleton4();
        }
        return INSTANCE;

    }
}
