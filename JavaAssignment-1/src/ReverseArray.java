import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the length of array: ");
		int n = sc.nextInt(); // length of array
		
		int[] array = new int[n];
		
		System.out.println("Enter the array elements: ");
		for(int i = 0;i<n;i++) {
			array[i] = sc.nextInt();
		}
		
		for(int i = 0;i<n;i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
		
		reverseArray(array,n);
		
		for(int i = 0;i<n;i++) {
			System.out.print(array[i] + " ");
		}
		
		
	}
	
	
	
	public static void reverseArray(int[] array, int n) {
		int[] b = new int[n];
		for(int i = n-1;i>=0;i--) {
			b[n-1-i] = array[i];
		}
		
		for(int i = 0;i<n;i++) {
			array[i] = b[i];
		}
		
	}

}
