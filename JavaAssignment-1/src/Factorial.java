import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number: ");
		int num = sc.nextInt();
		
		System.out.println("The factorial for entered number is: "  + factorial(num));
		
		
	}
	
	public static int factorial(int num) {
		
		if(num == 0) {
			return 1;
		}
		int temp = num - 1;
		
		while(temp !=0) {
			num = num*temp;
			temp --;
		}
		
		return num;
	}

}
