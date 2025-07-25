
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class ComputIfAbsentTest {

    @Test
    public void testComputIfAbsent() {
        Map<String, Integer> map = new HashMap<>();

        // 测试键不存在的情况
        Integer value = map.computeIfAbsent("key1", k -> k.length());
        assertEquals(4, value); // "key1" 的长度是 4
        assertEquals(4, map.get("key1"));

        // 测试键已经存在的情况
        Integer existingValue = map.computeIfAbsent("key1", k -> 10);
        assertEquals(4, existingValue); // 值应该是之前计算的 4，而不是 10
        assertEquals(4, map.get("key1"));
    }

    @Test
    public void testComputIfAbsentWithNullValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("key2", null);

        // 测试键存在但值为 null 的情况
        Integer value = map.computeIfAbsent("key2", k -> k.length());
        assertEquals(4, value); // "key2" 的长度是 4
        assertEquals(4, map.get("key2"));
    }


    public static void main(String[] args) {

        ComputIfAbsentTest test = new ComputIfAbsentTest();
        test.testComputIfAbsent();
//        test.testComputIfAbsentWithNullValue();

    }
}

