public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tl = new ListNode(-1);
        ListNode l = tl;
        int num = 0;
        int newNum = 0;
        while (l1 != null || l2 != null || num > 0) {
            newNum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + num;
            num = newNum / 10;
            l.next = new ListNode(newNum % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            l = l.next;
        }
        return tl.next;
    }
}

private class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
