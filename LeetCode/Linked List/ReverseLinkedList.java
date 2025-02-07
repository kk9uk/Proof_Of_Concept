public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode curr = head, prev = null, next = curr.next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /* tail recur: still O(n) time, ***probably*** O(1) space
     * public ListNode reverseList(ListNode head) {
     *     if (head == null) return null;
     *     return reverseListHelper(head, null);
     * }

     * private static ListNode reverseListHelper(ListNode curr, ListNode prev) {
     *     if (curr == null) return prev;
     *     ListNode next = curr.next;
     *     curr.next = prev;
     *     return reverseListHelper(next, curr);
     * } */
}