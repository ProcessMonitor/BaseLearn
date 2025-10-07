package Interview.micro;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class T1 {
    public static ListNode mergeTow(ListNode n1, ListNode n2) {
        ListNode cur = new ListNode(0);
        ListNode tail = cur;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                tail.next = n1;
                n1 = n1.next;
            } else {
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }
        tail.next = n1 != null ? n1 : n2;
        return cur.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(4);
        n2.next.next = new ListNode(6);

        ListNode res = mergeTow(n1, n2);

        while (res != null) {
            System.out.println(res.val + " ");
            res = res.next;
        }
    }
}
