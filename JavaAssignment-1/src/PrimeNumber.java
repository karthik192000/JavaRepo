import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		
		
		// Single prime number
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int number = in.nextInt();
		
		if(isPrime(number)) {
			System.out.println(number + " is a prime number");
		}
		else System.out.println(number + " is not a prime number");
		
		
		// Prime numbers between 2 to N 
		
		System.out.println("Enter the upper limit: ");
		int N = in.nextInt(); // upper limit N
		for(int i = 2;i<=N;i++) {
			if(isPrime(i)) System.out.println(i);
			else continue;
		}
	}
	
	public static boolean isPrime(int num) {
		if(num<=1) {
			return false;
		}
		
		for(int i =2;i<(num/2);i++) {
			if(num % i == 0) {
				return false;
			}
			
		}
		
		return true;
	}

}
