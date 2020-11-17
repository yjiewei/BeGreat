/*
 * @author yangjiewei
 * @date 2020/11/15 20:31
 */
package interview.singleton;

public class Test {
    public static void main(String[] args) {

        Singleton1 singleton1 = Singleton1.singleton;
        System.out.println(singleton1);

        Singleton2 singleton2 = Singleton2.INSTANCE;
        System.out.println(singleton2);

        Singleton3 singleton3 = Singleton3.singleton;
        System.out.println(singleton3.getInfo());

    }
}
