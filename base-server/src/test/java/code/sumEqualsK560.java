package code;

import java.util.HashMap;
import java.util.Map;

public class sumEqualsK560 {

    public int subarraySum(int[] nums, int k) {
        // 模拟退火
        int n = nums.length;
        int count = 0;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (prefixSum[i] - prefixSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumAdvanced(int[] nums, int k) {
        // 空间换时间
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1, 1, 1};
        int k = 2;
        sumEqualsK560 test = new sumEqualsK560();
        System.out.println(test.subarraySum(nums, k));
    }
}
