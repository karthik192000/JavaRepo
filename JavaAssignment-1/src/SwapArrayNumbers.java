import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SwapArrayNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the length of array: ");
		int n = sc.nextInt(); // array length
		List<Integer> array = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			array.add(sc.nextInt());
		}
		
		swapArrayNumbers(array);
		
		System.out.println(array);
		
	}
	
	public static void swapArrayNumbers(List<Integer> array) {
		int j = 0;
		int temp = 0;
		
		for(int i = 0;i<array.size()-1; i = i + 2){
			j = i+1;
			Collections.swap(array, i, j);

			
		}
	}
	

}
