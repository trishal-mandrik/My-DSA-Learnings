import java.util.Scanner;

public class ArmstrongNumber {
	
	public static void main(String[] args) {
		// Write your code here
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
        scanner.close();
		int copyN = n;
		int sum = 0;
		String number = String.valueOf(n);
		int length = number.length();
		while(n > 0) {
			int Ld = n % 10;
			n /= 10;
			sum += (int)Math.pow(Ld, length);
		}
		System.out.println(sum == copyN);
	}
}

