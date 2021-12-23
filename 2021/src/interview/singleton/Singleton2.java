package interview.singleton;

/**
 * Description：单例模式-静态内部类实现
 *
 * @author jiaoqianjin
 * Date: 2021/12/15 10:16
 **/

public class Singleton2 {
    private static volatile Singleton2 singleton2;

    private Singleton2() {
    }

    // 写一个静态内部类，改类中只有一个静态属性，利用类转载机制保证初始化实例时只有一个线程
    private static class SingletonInstance {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static synchronized Singleton2 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
