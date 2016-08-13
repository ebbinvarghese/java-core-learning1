package com.ebbin.learning.core.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ebbin.learning.exception.LearningException;
import com.ebbin.learning.exception.types.LearningExceptions;
import com.ebbin.learning.run.Run;

public class PalindromeNumber implements Run {

	@Override
	public void runApp() throws LearningException {
		
		String number;
		
		try {
			number = getUserInput();
		}
		catch(IOException | NumberFormatException e) {
			throw new LearningException(LearningExceptions.PALINDROME_INVALID_FORMAT);
		}
		if(isPalindrome(number)) {
			System.out.println(number + " is a palindrome");
		}
		else {
			System.out.println(number + " is not a palindrome");
		}
	}
	
	/**
	 * @author Ebbin
	 * Method to accept a number from user through console
	 * @throws IOException
	 * @throws NumberFormatException
	 * @return <String> The number inserted by user
	 */
	private String getUserInput() throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Palindrome Number Check:");
		System.out.print("Please enter the number: ");
		String number = br.readLine();
		
		Integer.parseInt(number);
		
		return number;
	}
	
	/**
	 * @author Ebbin
	 * Method to check whether an inserted no. is palindrome or not
	 * @param <String> number : The number to check for being a palindrome
	 * @return <boolean> True if number is a palindrome
	 * 					 False otherwise
	 */
	private boolean isPalindrome(String number) {
		
		int i, j;
		
		for(i = 0, j = number.length() - 1; i < number.length() / 2; ++i, --j) {
			if(number.charAt(i) != number.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
	
}
