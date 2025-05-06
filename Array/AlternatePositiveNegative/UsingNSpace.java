package Array.AlternatePositiveNegative;

// If we have same number of -ve and +ve elements
public class UsingNSpace {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int posIdx = 0, negIdx = 1;
        int[] ans = new int[n];
        for (int num : nums) {
            if (num < 0) {
                ans[negIdx] = num;
                negIdx += 2;
            } else {
                ans[posIdx] = num;
                posIdx += 2;
            }
        }
        return ans;
    }
}
