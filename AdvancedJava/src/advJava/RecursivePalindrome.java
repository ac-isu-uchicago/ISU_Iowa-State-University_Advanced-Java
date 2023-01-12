package advJava;

import java.util.Scanner;


public class RecursivePalindrome {
	public static boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}
	
	private static boolean isPalindrome(String s, int low, int high) {
		if (high <= low)
			return true;
		else if (s.charAt(low) != s.charAt(high))
			return false;
		else
			return isPalindrome(s, low + 1, high - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is moon a Palindrome?" + isPalindrome("moon"));
		

	}

}
