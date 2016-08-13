package com.ebbin.learning.core.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ebbin.learning.exception.LearningException;
import com.ebbin.learning.exception.types.LearningExceptions;
import com.ebbin.learning.run.Run;

public class FibonacciSeries implements Run {

	@Override
	public void runApp()throws LearningException {
		
		try {
			int seriesLimit = 0;
			seriesLimit = getUserInput();
			generateFibonacciSeries(seriesLimit);
		}
		catch(IOException | NumberFormatException e) {
			throw new LearningException(LearningExceptions.FIBONACCI_SERIES_INVALID_FORMAT);
		}
	}	
		
	
	/**
	 * @author Ebbin
	 * Method to accept the fibonacci series limit from user through console
	 * @throws IOException
	 * @throws NumberFormatException
	 * @return <String> The series limit entered by the user
	 */
	private int getUserInput() throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Fibonacci Series Generator");
		System.out.print("Please enter the series limit: ");
		
		int seriesLimit = Integer.parseInt(br.readLine());
		
		return seriesLimit;
	}
	
	/**
	 * @author Ebbin
	 * Method to generate the Fibonacci series
	 * @param <int> seriesLimit : The no. of elements in the Fibonacci series to be generated
	 * @throws LearningException
	 */
	private void generateFibonacciSeries(int seriesLimit) throws LearningException {
		
		if(seriesLimit < 2) {
			throw new LearningException(LearningExceptions.FIBONACCI_SERIES_LOWER_LIMIT);
		}
		
		int i,first,second,third;
		first = 0;
		second = 1;
		
		System.out.print(first + ", " + second);
		for(i = 2; i < seriesLimit; ++i) {
			third = first + second;
			System.out.print(", " + third);
			first = second;
			second = third;
		}
	}
	
}
