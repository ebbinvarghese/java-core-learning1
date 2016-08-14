package com.ebbin.learning.main;

import com.ebbin.learning.exception.LearningException;
import com.ebbin.learning.run.Run;

import com.ebbin.learning.core.basic.FibonacciSeries;
import com.ebbin.learning.core.basic.PalindromeNumber;
import com.ebbin.learning.core.basic.BubbleSort;
import com.ebbin.learning.core.basic.FileCopy;

public class Main {

	/**
	 * @author Ebbin
	 */
	public static void main(String[] args) {

		try {
//			Run run = new FibonacciSeries();
//			Run run = new PalindromeNumber();
//			Run run = new BubbleSort();
			Run run = new FileCopy();
			run.runApp();
		}
		catch(LearningException le) {
			System.err.println(le.getMessage());
			le.printStackTrace();
			le.getCause();
		}
		
	}

}