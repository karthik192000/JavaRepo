
public class NumberPatterns {

	public static void main(String[] args) {
//a. for n = 4		
//		1
//		22
//		333
//		4444
		
		for(int i = 1;i<=4;i++) {
			for(int j = 1;j<=i;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		System.out.println("==============================================================");
//b. for n = 4	
//		4444
//		4444
//		4444
//		4444
		
		for(int i = 1;i<=4;i++) {
			for(int j = 1;j<=4;j++) {
				System.out.print(4);
			}
			System.out.println();
		}
		
		System.out.println("==============================================================");
//c. for n = 5	
//		*
//	   **
//	  ***
//	 ****
//	***** 
		
		for(int row = 0;row < 5;row++) {
			for(int col = 0;col< 5;col++) {
				if(col < 5-row-1) {
					System.out.print(" ");	
				}
				else System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==============================================================");
		

		
		
		

	}

}
