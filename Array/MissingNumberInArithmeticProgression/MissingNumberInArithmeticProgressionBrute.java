package Array.MissingNumberInArithmeticProgression;

public class MissingNumberInArithmeticProgressionBrute {
    int findMissing(int[] arr) {
        // code here
        /* Sum of the n elements = (n/2)(a+l)
         n is the number of elements, a is the first element and l is the last element */
        int s;
        int size = arr.length;
        int firstElement = arr[0];
        int lastElement = arr[size - 1];

        if ((firstElement + lastElement) % 2 == 0) {
            s = (firstElement + lastElement) / 2;
            s = s * (size + 1);
        } else {
            s = (size + 1) / 2;
            s = (firstElement + lastElement) * s;
        }
        int sum = 0;

        for (int j : arr) {
            sum += j;
        }
        return s - sum;
    }
}
