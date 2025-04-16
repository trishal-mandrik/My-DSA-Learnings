package Array.MoveAllNegativeElementsToEnd;

import java.util.Stack;

// Without changing the position
public class MoveAllNegativeElementsToEnd {
    public void segregateElements(int[] arr) {
        // Your code goes here
        Stack<Integer> neg = new Stack<>();
        Stack<Integer> pos = new Stack<>();

        for (int j : arr) {
            if (j < 0) neg.push(j);
            else pos.push(j);
        }

        int idx = arr.length - 1;

        while (!neg.isEmpty()) {
            arr[idx] = neg.pop();
            idx--;
        }

        while (!pos.isEmpty()) {
            arr[idx] = neg.pop();
            idx--;
        }
    }
}
