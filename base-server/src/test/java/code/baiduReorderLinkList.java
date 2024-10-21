package code;

public class baiduReorderLinkList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return; // 如果链表节点少于4个，不需要重排
        }

        // 找到链表的中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode prev = null, curr = slow.next;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        slow.next = null; // 断开原链表的后半部分

        // 合并两个链表
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            // 重排连接
            first.next = second;
            second.next = firstNext;

            // 移动指针
            first = firstNext;
            second = secondNext;
        }
    }
}

