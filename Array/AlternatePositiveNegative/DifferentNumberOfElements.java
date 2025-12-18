package Array.AlternatePositiveNegative;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// If we have different number of -ve and +ve elements
public class DifferentNumberOfElements {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();

        for (Integer integer : arr) {
            if (integer < 0) {
                negative.add(integer);
            } else {
                positive.add(integer);
            }
        }

        boolean posi = true;
        arr.clear();
        while (!positive.isEmpty() && !negative.isEmpty()) {
            if (posi) {
                arr.add(positive.poll());
                posi = false;
            } else {
                arr.add(negative.poll());
                posi = true;
            }
        }

        while (!positive.isEmpty()) {
            arr.add(positive.poll());
        }

        while (!negative.isEmpty()) {
            arr.add(negative.poll());
        }
    }
}
