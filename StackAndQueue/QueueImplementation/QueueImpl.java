package StackAndQueue.QueueImplementation;

public class QueueImpl {
    int maxSize = 5;
    int front = -1;
    int rear = -1;
    int currSize = 0;
    int[] queue = new int[maxSize];

    public void enqueue(int data) {
        if (rear == maxSize - 1) {
            System.out.println("Queue Overflow");
        }

        if (currSize == 0) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % maxSize;
        }
        queue[rear] = data;
        currSize++;
    }

    public int dequeue() {
        if (currSize == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int element = queue[front];
        if (currSize == 1) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
        currSize--;
        return element;
    }

    public int top() {
        if (currSize != 0) {
            return queue[front];
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }
}
