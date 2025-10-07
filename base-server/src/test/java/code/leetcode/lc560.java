package code.leetcode;

public class lc560 {
        public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (prefixSum[i] - prefixSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        int result = new lc560().subarraySum(nums, k);
        System.out.println("The number of subarrays with sum " + k + " is " + result);
    }
}
