package Interview.lcTest;
//Input: nums = [2,7,11,15],
//target = 9
//Output: [0,1]

public class T1 {
    //    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int cur = target - nums[i];
//            if (map.containsKey(cur)) {
//                return new int[]{map.get(cur), i};
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException(" no index");
//    }
//
//    public static void main(String[] args) {
//        T1 t1 = new T1();
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        int[] result = t1.twoSum(nums, target);
//        System.out.println(result);
//    }
    // int 数组 已经排序 1 - 10  ，  找到三个数相加  === 22 打印三数
//    public static List<List<Integer>> findThreeSum(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        int n = nums.length;
//
//        for (int i = 0; i < n - 2; i++) {
//
//            int left = i + 1;
//            int right = n - 1;
//            while (left < right) {
//                int sum = nums[i] + nums[left] + nums[right];
//                if (sum == target) {
//                    result.add(List.of(nums[i], nums[left], nums[right]));
//                    while (left < right && nums[left] == nums[left++]) left++;
//                    while (left < right && nums[right] == nums[right--]) right--;
//                    left++;
//                    right--;
//
//                } else if (sum < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int[] nums  = { 1,2,3,4,5,6,7,8,9,10};
//        int target = 22;
//        List<List<Integer>> result = findThreeSum(nums , target);
//        System.out.println(result);
//    }


//    MPT 分单 推荐 智能运营 b/c端 预算和活动 补贴奖励 etc...  提升成单率 工程+算法
//    偏 b 端业务 和 算法部门对接。

//    项目深挖  抗压
//    基础扎实 组件了解
//    新问题 的解决能力

//    1.智能运营（高效分配资金）  定价补贴工具 -》 补贴司乘  拉更多乘客 调动更多司机，以创造更多订单
//    2.司机推荐（调度指令 感知 推荐） 订单定价 根据供需来实时定价 wanhao
//    当前： 网约车品类太多 ， 市场监管 -》 精细化策略 （越来越复杂 难以管理）   如何保证系统稳定和效率。

//    public boolean verifyPostOrder(int[] postorder) {
//        if (postorder == null || postorder.length == 0) {
//            return true;
//        }
//        return verify(postorder, 0, postorder.length - 1);
//    }
//
//    public boolean verify(int[] postorder, int start, int end) {
//        if (start > end) {
//            return true;
//        }
//
//        int root = postorder[end];
//        int i = start;
//
//        while (i < end && postorder[i] < root) {
//            i++;
//        }
//
//        for (int j = i; j < end; j++) {
//            if (postorder[j] < root) {
//                return false;
//            }
//        }
//
//        return verify(postorder, start, i - 1) && verify(postorder, i, end - 1);
//
//    }
//
//    public static void main(String[] args) {
//        int[] postorder = new int[]{5, 7, 6, 9, 11, 10, 8};
//        System.out.println(new T1().verifyPostOrder(postorder));
////        int[] postorder = new int[]{7, 4, 6, 5};
////        System.out.println(new T1().verifyPostOrder(postorder));
//    }


    // 有序链表 合并 123 246 -> 122346
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }


    public static ListNode mergeTwo(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;


        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));

        ListNode l2 = new ListNode(3, new ListNode(5, new ListNode(6)));

        ListNode result = mergeTwo(l1, l2);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}

