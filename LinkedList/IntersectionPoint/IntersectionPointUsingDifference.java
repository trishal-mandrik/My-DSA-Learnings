package LinkedList.IntersectionPoint;

import LinkedList.ListNode;

public class IntersectionPointUsingDifference {
    static int getDifference(ListNode head1, ListNode head2) {
        int len1 = 0, len2 = 0;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != null || head2 != null) {
            if(temp1 != null) {
                len1++;
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                len2++;
                temp2 = temp2.next;
            }
        }
        //if difference is neg-> length of list2 > length of list1 else vice-versa
        return len1 - len2;
    }

    //utility function to check presence of intersection
    static ListNode intersectionPresent(ListNode head1,ListNode head2) {
        int diff = getDifference(head1, head2);
        if (diff < 0)
            while (diff++ != 0) head2 = head2.next;
        else
            while (diff-- != 0) head1 = head1.next;
        while(head1 != null) {
            if(head1 == head2) return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return null;
    }
}

//Time Complexity:
//
//O(2max(length of list1,length of list2))+O(abs(length of list1-length of list2))+O(min(length of list1,length of list2))
//
//Reason: Finding the length of both lists takes max(length of list1, length of list2) because it is found simultaneously for both of them. Moving the head pointer ahead by a difference of them. The next one is for searching.
//
//Space Complexity: O(1)
//
//Reason: No extra space is used.
