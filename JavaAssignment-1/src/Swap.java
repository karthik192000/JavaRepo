import java.util.Scanner;

public class Swap {

	private int a;
	private int b;

	Swap(int a, int b) {
		this.a = a;
		this.b = b;

	}

	public void swapNumbers() {
		
		int temp = this.a;
		this.a = this.b;
		this.b = temp;

	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number: ");
		int a = sc.nextInt();
		System.out.println("Enter the second number: ");
		int b = sc.nextInt();
		
		Swap swap = new Swap(a,b);
		
		
		
		System.out.println("Before swap: "  + "\n"
				+ "a: " + swap.getA()  + "\n"
				+ "b: " + swap.getB());
		
		swap.swapNumbers();
		
		System.out.println("After swap: "  + "\n"
				+ "a: " + swap.getA()  + "\n"
				+ "b: " + swap.getB());
		
	}

}
