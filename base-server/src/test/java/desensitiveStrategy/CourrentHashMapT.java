package desensitiveStrategy;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

public class CourrentHashMapT {
    @Test
    void concurrentHashMapTest(){
        System.out.println(this + " " + this.getClass().getName());
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    }
}
