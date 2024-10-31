public class twoLinkMaxCommonSame {
    // 定义链表节点类
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 找出两个链表的公共最长子串长度
    public int longestCommonSubstringLength(ListNode head1, ListNode head2) {
        int maxLength = 0;

        ListNode curr1 = head1;

        // 遍历链表1的每个节点作为起始节点
        while (curr1 != null) {
            ListNode curr2 = head2;
            int currentLength = 0;

            // 从当前节点开始比较链表1和链表2
            while (curr1 != null && curr2 != null && curr1.val == curr2.val) {
                currentLength++;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }

            // 更新最长公共子串长度
            maxLength = Math.max(maxLength, currentLength);

            // 继续遍历链表1的下一个节点
            curr1 = curr1 != null ? curr1.next : null;
        }

        return maxLength;
    }
}
