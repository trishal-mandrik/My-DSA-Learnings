package LinkedList.MiddleOfList;

import LinkedList.ListNode;

public class MiddleOfListOptimal {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null || fast.next != null || slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

//TC: O(n)
//SC: O(1)