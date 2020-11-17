/*
 * @author yangjiewei
 * @date 2020/11/15 19:20
 */
package interview.singleton;

/**
 * 饿汉式 在类初始化的时候创建<clinit>
 *      构造器私有
 *      静态变量存储
 *      向外提供
 *      final修饰
 */
public class Singleton1 {

    public static final Singleton1 singleton = new Singleton1();

    private Singleton1(){
    }

}
