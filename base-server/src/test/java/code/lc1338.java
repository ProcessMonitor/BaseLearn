package code;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc1338 {

    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());
        int res = 0, sum = 0;
        while (sum < arr.length / 2) {
            if (pq.stream().findFirst().isPresent()) {
                sum += pq.poll();
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 1};
        System.out.println(minSetSize(nums));
    }
}
