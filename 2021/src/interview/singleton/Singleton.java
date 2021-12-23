package interview.singleton;

/**
 * Description：单例模式-双重检查
 *
 * @author jiaoqianjin
 * Date: 2021/12/15 10:07
 **/

public class Singleton {
    private volatile static Singleton singleton;
    public Singleton() {

    }

    private static Singleton getUniqueInstance() {
        if (singleton == null) {
            synchronized (singleton.getClass()) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
