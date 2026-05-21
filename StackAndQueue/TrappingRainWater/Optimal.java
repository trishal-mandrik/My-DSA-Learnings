package StackAndQueue.TrappingRainWater;

public class Optimal {
    public int maxWater(int[] arr) {
        int lmax = 0, rmax = 0, total = 0, l = 0, r = arr.length - 1;

        while (l < r) {
            if (arr[l] <= arr[r]){
                if (lmax > arr[l]){
                    total += lmax - arr[l];
                } else {
                    lmax = arr[l];
                }
                l++;
            } else {
                if (rmax > arr[r]){
                    total += rmax - arr[r];
                } else {
                    rmax = arr[r];
                }
                r--;
            }
        }
        return total;
    }
}

//TC: O(N)
//SC: O(1)