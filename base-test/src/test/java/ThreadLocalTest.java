import java.util.HashMap;
import java.util.Hashtable;

public class ThreadLocalTest {

    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    HashMap<String, String> map = new HashMap<String, String>();

    Hashtable<String, String> hashtable = new Hashtable<String, String>();


    public void test() {
        threadLocal.set("threadLocalSet");
        map.put("mapkey", "mapval");
        hashtable.put("hashtable", "hashtableval");

        System.out.println(threadLocal.get());
        System.out.println(map.get("mapkey"));
        System.out.println(hashtable.get("hashtable"));
        System.out.println(Thread.currentThread().getName());
        System.out.println(this);
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getSimpleName());
        System.out.println(this.getClass().getPackage().getName());
        System.out.println(this.getClass().getCanonicalName());
        System.out.println(this.getClass().getEnclosingClass());
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        test.test();
    }


}
