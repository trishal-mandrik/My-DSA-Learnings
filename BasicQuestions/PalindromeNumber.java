public class PalindromeNumber {
    public static boolean palindromeNumber(int n) {
        // Write your code here.
        int copy = n;
        int revNum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            n /= 10;
            revNum = (revNum * 10) + lastDigit;
        }
        return copy == revNum;
    }
}