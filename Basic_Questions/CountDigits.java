public class CountDigits {
    public static int countDigits(int n){
        // Write your code here.
        int cnt = 0;
        while(n > 0) {
            // int last_digit = n % 10;
            cnt++;
            n /= 10;
        }
        return cnt;
    }
}


// can be solved with log as well
