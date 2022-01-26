import java.util.*;
public class Vowels {

	public static void main(String[] args) {
		final List<Integer> vowelsList = Arrays.asList(65,69,73,79,85,97,101,105,111,117);
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a character: ");
		
		char c = sc.next().charAt(0);
		
		if (vowelsList.contains((int) c)) {
			System.out.println("The entered character is a vowel");
		}
		else System.out.println("The entered character is not a vowel");
	}

}
