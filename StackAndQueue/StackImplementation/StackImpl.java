package StackAndQueue.StackImplementation;

public class StackImpl {
    int top = -1;
    int maxSize = 5;

    int[] stack = new int[maxSize];

    public void push(int data) {
        if(top == maxSize - 1) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            stack[top] = data;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if(top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int currentSize() {
        return top + 1;
    }
}

//TC: O(1) for push, pop, peek, isEmpty, currentSize
//SC: O(5) where N is the maxSize of the stack
