package alexromanov.engconcepts.patterns.singleton;


/*
* In multicore system there is no way how to read instance value by different threads. So while one thread is
* holding a key to synchronized instance, the
* others will wait for some timeout in order to get the key of the object.
* It can lead to a performance degradation.
* */
public final class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {};

    public static synchronized SynchronizedSingleton getInstance(){
        if (instance == null){
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
