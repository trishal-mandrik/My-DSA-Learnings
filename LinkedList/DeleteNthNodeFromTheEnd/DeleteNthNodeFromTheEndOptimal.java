package LinkedList.DeleteNthNodeFromTheEnd;

import LinkedList.ListNode;

public class DeleteNthNodeFromTheEndOptimal {
    ListNode DeleteNthNodeFromTheEnd(ListNode head, int N) {
        // Create two pointers, fastp and slowp
        ListNode fastp = head;
        ListNode slowP = head;

        // Move the fastp pointer N nodes ahead
        for (int i = 0; i < N; i++) {
            fastp = fastp.next;
        }

        // If fastp becomes null, the Nth node from the end is the head
        if (fastp == null) return head.next;

        // Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowP = slowP.next;
        }

        // Delete the Nth node from the end
        slowP.next = slowP.next.next;
        return head;
    }
}
