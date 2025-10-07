package Interview.lcTest;


import java.util.ArrayList;
import java.util.List;

public class lc3703 {

    public String removeSubstring(String s, int k) {
        // s  =  "((((()))))"
//
//        int left = 0, right = s.length();
//        int count = 0;
//
//
//        boolean isBalanced = true;
//
//        while (isBalanced) {
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == '(') {
//                    count++;
//                    if (count == k) {
//                        left = i;
//                        isBalanced = false;
//                        break;
//                    }
//                }
//            }
//
//            for (int i = left; i < s.length(); i++) {
//                if (s.charAt(i) == ')') {
//                    count--;
//                    if (count == 0) {
//                        right = i;
//                        isBalanced = false;
//                        break;
//                    }
//                }
//            }
//            // 此时 left --- right 是一个括号对 删除left 到 right的子串
//            s = s.substring(0, left) + s.substring(right + 1);
//        }
//
//        return s;

        List<int[]> st = new ArrayList<>(); // 栈中保存 [字符, 连续出现次数]
        for (char b : s.toCharArray()) {
            if (!st.isEmpty() && st.getLast()[0] == b) {
                st.getLast()[1]++; // 连续相同括号个数 +1
            } else {
                st.add(new int[]{b, 1}); // 新的括号
            }

            // 栈顶的 k 个右括号与栈顶下面的 k 个左括号抵消
            if (b == ')' && st.size() > 1 && st.getLast()[1] == k && st.get(st.size() - 2)[1] >= k) {
                st.removeLast();
                st.getLast()[1] -= k;
                if (st.getLast()[1] == 0) {
                    st.removeLast();
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int[] p : st) {
            ans.repeat(p[0], p[1]);
        }
        return ans.toString();
    }
}