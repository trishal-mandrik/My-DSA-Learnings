public class Solution {

	public static int sqrtN(long N) {
		long low = 1, high = N;

		while(low <= high){
			long mid = low + (high - low)/2;
			long val = (mid * mid);

			if(val <= N) low = mid + 1;
			else high = mid - 1;
		}
		return (int)(high);
	}
}
