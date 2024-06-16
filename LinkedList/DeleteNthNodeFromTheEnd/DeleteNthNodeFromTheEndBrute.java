package LinkedList.DeleteNthNodeFromTheEnd;

import LinkedList.ListNode;

public class DeleteNthNodeFromTheEndBrute {
    public static ListNode DeleteNthNodeFromTheEnd(ListNode head, int N) {
        if (head == null) return null;

        int cnt = 0;
        ListNode temp = head;

        // Count the number of nodes in the linked list
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // If N equals the total number of nodes, delete the head
        if (N == cnt) {
            head = head.next;
            return head;
        }

        // Calculate the position of the node to delete (res)
        int res = cnt - N;
        temp = head;

        // Traverse to the node just before the one to delete
        while (temp != null) {
            res--;
            if (res == 0) break;
            temp = temp.next;
        }

        // Delete the Nth node from the end
        assert temp != null;
        temp.next = temp.next.next;
        return head;
    }
}

//Time Complexity: O(L)+O(L-N), We are calculating the length of the linked list and then iterating up to the (L-N)th node of the linked list, where L is the total length of the list.
//
//Space Complexity:  O(1), as we have not used any extra space.
