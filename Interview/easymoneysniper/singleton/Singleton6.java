/*
 * @author yangjiewei
 * @date 2020/11/16 10:07
 */
package interview.singleton;

/**
 * 前三个都是饿汉式 可能会造成资源浪费，但是安全
 * 接下来是懒汉式，资源利用率高，在5的基础上改善性能问题 DCL
 *      1.构造器私有化
 *      2.提供get获得对象的方法，注意线程安全问题
 */
public class Singleton6 {
    private static Singleton6 INSTANCE;
    private Singleton6(){}
    public Singleton6 getINSTANCE(){

        if (INSTANCE == null){
            // 虽然线程安全了，但是锁粒度大，效率低
            synchronized (Singleton6.class){
                if (INSTANCE != null){
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;

    }
}
