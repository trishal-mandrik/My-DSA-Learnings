package LinkedList.ReverseList;

import LinkedList.ListNode;

public class ReverseList_Recursive {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}

// TC: O(N)
// SC: O(1)
