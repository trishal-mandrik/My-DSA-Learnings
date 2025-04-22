// package Binary-Search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int start = 0;
        int end = arr.length;
        int mid = start + (end - start) / 2;
        int toFind = 3;

        while (start <= end) {
            if (arr[mid] == toFind) {
                System.out.println("Found at index " + mid);
                return;
            } else if (toFind < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        System.out.println("not found");
    }
}
