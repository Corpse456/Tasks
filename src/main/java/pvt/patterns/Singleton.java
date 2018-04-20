package pvt.patterns;

public class Singleton {

    private static Singleton inst = null;
    
    public static Singleton getInstance () {
        if (inst == null) inst = new Singleton();
        return inst;
    }

    private Singleton () {
    }

}
