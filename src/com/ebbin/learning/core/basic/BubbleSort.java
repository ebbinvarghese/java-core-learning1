package com.ebbin.learning.core.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ebbin.learning.exception.LearningException;
import com.ebbin.learning.exception.types.LearningExceptions;
import com.ebbin.learning.run.Run;

public class BubbleSort implements Run {
	
	public enum sortType {
		ASC,
		DESC;
	}
	
	private static final int ARRAY_LOWER_LIMIT = 2;
	private static final int ARRAY_UPPER_LIMIT = 10;

	@Override
	public void runApp() throws LearningException {
		
		int[] numArray = new int[ARRAY_UPPER_LIMIT];
		int length;
		
		try {
			length = getUserInput(numArray);
		}
		catch(IOException | NumberFormatException e) {
			throw new LearningException(LearningExceptions.BUBBLE_SORT_INVALID_FORMAT);
		}
		
		bubbleSort(numArray, length, sortType.DESC);
		printArray(numArray, length);
	}
	
	/**
	 * @author Ebbin
	 * Method to accept an array of numbers from the user through console
	 * @throws IOException
	 * @throws NumberFormatException
	 * @param <int[]> numArray: The array of numbers inserted by the user is returned through this parameter
	 * @return The length of the user input array of numbers
	 */
	private int getUserInput(int[] numArray) throws IOException, NumberFormatException, LearningException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bubble Sort");
		System.out.print("Please enter the number array to be sorted: ");
		String userInput = br.readLine();
		String[] inputNos = userInput.trim().split("(\\s)+");
		int i;
		int length = inputNos.length;
		
		if(length < ARRAY_LOWER_LIMIT) {
			throw new LearningException(LearningExceptions.BUBBLE_SORT_ARRAY_LOWER_LIMIT);
		}
		else if(length > ARRAY_UPPER_LIMIT) {
			throw new LearningException(LearningExceptions.BUBBLE_SORT_ARRAY_UPPER_LIMIT);
		}
		
		for(i = 0;i < length; ++i) {
			numArray[i] = Integer.parseInt(inputNos[i]);
		}
		
		return length;
	}
	
	/**
	 * @author Ebbin
	 * Method to sort an array of numbers in ascending|descending order
	 * @param <int[]> numArray: The array of numbers entered by user
	 * @param <int> length: The length of the numArray
	 * @param <sortType> type: ASC Sort the array in ascending order
	 * 						   DESC Sort the array in descending order
	 */
	public void bubbleSort(int[] numArray, int length, sortType type) {
		
		int i, j, temp;
		
		for(i = 0; i < length - 1; ++i) {
			for(j = i + 1; j < length; ++j) {
				switch(type) {
				case ASC: 
				default:
						if(numArray[i] > numArray[j]) {
							temp = numArray[i];
							numArray[i] = numArray[j];
							numArray[j] = temp;
						}
						break;
							
				case DESC:
						if(numArray[i] < numArray[j]) {
							temp = numArray[i];
							numArray[i] = numArray[j];
							numArray[j] = temp;
						}
						break;
				}
			}
		}
	}
	
	/**
	 * @author Ebbin
	 * Method to print an array of numbers
	 * @param <int[]> numArray: The array of numbers to be printed
	 * @param <int> length: The length of numArray
	 */
	private void printArray(int[] numArray, int length) {
		
		int i;
		
		System.out.println("The array is: ");
		for(i = 0; i < length; ++i) {
			if(i == 0) {
				System.out.print(numArray[i]);
			}
			else {
				System.out.print(", " + numArray[i]);
			}
		}
	}
	
}
