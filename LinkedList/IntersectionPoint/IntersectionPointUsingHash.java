package LinkedList.IntersectionPoint;

import LinkedList.ListNode;

import java.util.HashSet;

public class IntersectionPointUsingHash {
    static ListNode intersection(ListNode head1, ListNode head2) {
        HashSet<ListNode> h = new HashSet<>();
        while (head1 != null) {
            h.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (h.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }
}

//Time Complexity: O(n+m)
//
//Reason: Iterating through list 1 first takes O(n), then iterating through list 2 takes O(m).
//
//Space Complexity: O(n)
//
//Reason: Storing list 1 node address in HashSet.
