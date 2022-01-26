import java.util.Scanner;

public class EvenSum {

	public static void main(String[] args) {
		
		System.out.println("Enter a number: ");
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int sum = 0;
		
		for(int i  =0;i<= N;i++) {
			sum = sum +i;
		}
		
		System.out.println("The sum is: ");
		System.out.print(sum);
		
	}

}
