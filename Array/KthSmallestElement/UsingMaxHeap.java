package Array.KthSmallestElement;

import java.util.PriorityQueue;

public class UsingMaxHeap {
    public static int kthSmallest(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int j : arr) {
            pq.offer(j);

            // If the size of the max heap exceeds K, remove the largest element
            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}

//Time Complexity: O(N * log(K)), The approach efficiently maintains a container of the K smallest elements while iterating through the array, ensuring a time complexity of O(N * log(K)), where N is the number of elements in the array.
//Auxiliary Space: O(K)
