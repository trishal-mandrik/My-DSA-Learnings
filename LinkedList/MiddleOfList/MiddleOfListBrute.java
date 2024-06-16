package LinkedList.MiddleOfList;

import LinkedList.ListNode;

public class MiddleOfListBrute {
    int getSize(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int size = getSize(head);
//        If there are two middle nodes, return the second middle node.
        int mid = size / 2 + 1;
        int i = 1;
        ListNode temp = head;
        while (i < mid) {
            temp = temp.next;
            i++;
        }
        return temp;
    }
}

//Time Complexity: O(N+N/2) The code traverses the entire linked list once and half times and then only half in the second iteration, first to count the number of nodes then then again to get to the middle node. Therefore, the time complexity is linear, O(N + N/2) ~ O(N).
//
//Space Complexity : O(1) There is constant space complexity because it uses a constant amount of extra space regardless of the size of the linked list. We only use a few variables to keep track of the middle position and traverse the list, and the memory required for these variables does not depend on the size of the list.
