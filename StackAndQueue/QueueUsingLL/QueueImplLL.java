package StackAndQueue.QueueUsingLL;

import LinkedList.ListNode;

public class QueueImplLL {
    ListNode start, end;
    int size = 0;

    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);

        if (start == null) {
            start = newNode;
        } else {
            end.next = newNode;
        }
        end = newNode;
        size++;
    }

    public int dequeue() {
        if (start == null) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int element = start.val;
        start = start.next;
        size--;
        if (size == 0) {
            end = null;
        }
        return element;
    }
}
