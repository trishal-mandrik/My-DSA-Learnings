package Array.SecondLargestElementInArray;

public class Optimal {
    public int getSecondLargest(int[] arr) {
        int largest = arr[0], secondLargest = -1;

        for(int i: arr) {
            if(i > largest) {
                secondLargest = largest;
                largest = i;
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}

// TC: O(N) where N is the number of elements in the array
// SC: O(1)