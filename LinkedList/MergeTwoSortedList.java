package LinkedList;

public class MergeTwoSortedList {
    ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // If any list still has remaining
        // elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummyNode.next;
    }
}
