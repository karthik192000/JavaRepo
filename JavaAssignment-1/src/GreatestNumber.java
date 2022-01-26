import java.util.Scanner;

public class GreatestNumber {
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number: ");
		
		int a = sc.nextInt();
		
		System.out.println("Enter the second number: ");
		
		int b = sc.nextInt();
		
		System.out.println("Enter the third number: ");
		
		int c = sc.nextInt();
		
		
		System.out.println("The greatest number is: " + greatestNumber(a,b,c));
		
		
		
		
		
		
	}
	
	public static int greatestNumber(int a,int b, int c)  {
		if(a>b && a>c) {
			return a;
		}		
		
		else if(b > a && b>c) {
			return b;
		}
		else return c;
	}

}
