package alexromanov.engconcepts.patterns.singleton;

/*
* Fix is to add volatile to instance
* */
public final class DoubleCheckedLockingSingleton {
    private static final Object key = new Object();
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton(){};

    public static DoubleCheckedLockingSingleton getInstance(){
        if (instance != null) {
            return instance;
        }

        synchronized (key) {
            if (instance == null){
                instance = new DoubleCheckedLockingSingleton();
            }
            return instance;
        }
    }
}
