/*
 * @author yangjiewei
 * @date 2020/11/15 19:20
 */
package interview.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * 饿汉式
 *      构造器私有
 *      静态变量存储
 *      向外提供
 *      final修饰
 */
public class Singleton3 {

    public static final Singleton3 singleton;
    private String info;

    static{
        Properties properties = new Properties();
        try {
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("singleton3.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        singleton = new Singleton3(properties.getProperty("info"));
    }

    private Singleton3(String info){
        this.info = info;
    }

    public static Singleton3 getSingleton() {
        return singleton;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
