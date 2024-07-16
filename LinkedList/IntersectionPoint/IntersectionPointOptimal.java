package LinkedList.IntersectionPoint;

import LinkedList.ListNode;

public class IntersectionPointOptimal {
    ListNode intersectionPoint(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != temp2) {
            temp1 = temp1 == null ? head2 : temp1.next;
            temp2 = temp2 == null ? head1 : temp2.next;
        }
        return temp1;
    }
}

//Time Complexity: O(2*max(length of list1,length of list2))
//
//Reason: Uses the same concept of the difference of lengths of two lists.
//
//Space Complexity: O(1)
//
//Reason: No extra data structure is used
