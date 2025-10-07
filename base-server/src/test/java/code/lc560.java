package code;

public class lc560 {

    public int subarraySum(int[] nums, int k) {

        int n = nums.length;

        int[] s = new int[n + 1];
        int count = 0;
        /**
         * 示例 1：
         * 输入：nums = [1,1,−1,1,−1], k = 2
         * s[0] = 1  , s[1] = 2  s[2] = 1 s[3] = 2 s[4] = 1;
         * s[i] + k = s[j];  s[i] - s[j] = k;
         * 输出：2
         */
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--){
                sum += nums[j];
//                preFixSum[i] = preFixSum[i - 1] + nums[i - 1];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;
        lc560 test = new lc560();

        System.out.println(test.subarraySum(nums, k));
    }
}
