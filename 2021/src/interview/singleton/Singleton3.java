package interview.singleton;

/**
 * Description：单例模式-枚举
 *
 * @author jiaoqianjin
 * Date: 2021/12/15 10:22
 **/

public class Singleton3 {
    private Singleton3() {
    }

    // 枚举类型是线程安全的
    private enum Singleton {
        INSTANCE;

        private final Singleton3 singleton3;

        Singleton() {
            singleton3 = new Singleton3();
        }
        private Singleton3 getInstance() {
            return singleton3;
        }
    }
    private static Singleton3 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
