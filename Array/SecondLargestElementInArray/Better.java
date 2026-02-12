package Array.SecondLargestElementInArray;

public class Better {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = arr[0], secondLargest = -1;

        // first pass
        for (int j : arr) {
            if (j > largest) largest = j;
        }

        // second pass
        for (int j : arr) {
            if (j > secondLargest && j < largest) secondLargest = j;
        }
        return secondLargest;
    }
}

// TC: O(N + N) where N is the number of elements in the array
// SC: O(1)