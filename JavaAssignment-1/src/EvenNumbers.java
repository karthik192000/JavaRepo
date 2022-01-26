
public class EvenNumbers {

	public static void main(String[] args) {
		
		
		// using while
		System.out.println("Even numbers from 1-50 using while loop");
		int i = 1;
		
		while(i <= 50) {
			if(i % 2 ==0) System.out.println(i);
			i++;
		}
		
		//using do-while
		System.out.println("Even numbers from 50-100 using do-while");
		int j = 50;
		
		do {
			if(j %2 == 0) System.out.println(j);
			j++;
			
		}while(j<=100);
	}

}
