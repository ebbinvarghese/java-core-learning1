package com.ebbin.learning.exception.types;

public enum LearningExceptions {

	FIBONACCI_SERIES_INVALID_FORMAT("Core-Basic-Fibonacci: Invalid input format. Number expected"),
	FIBONACCI_SERIES_LOWER_LIMIT("Core-Basic-Fibonacci: Cannot specify limit lower than 2"),
	PALINDROME_INVALID_FORMAT("Core-Basic-Palindrome: Invalid input format. Number expected"),
	BUBBLE_SORT_ARRAY_LOWER_LIMIT("Core-Basic-BubbleSort: Cannot specify array with less than 2 elements"),
	BUBBLE_SORT_ARRAY_UPPER_LIMIT("Core-Basic-BubbleSort: Cannot specify array with more than 5 elements"),
	BUBBLE_SORT_INVALID_FORMAT("Core-Basic-BubbleSort: Invalid input format. Numeric array expected"),
	FILE_COPY_FILE_NOT_FOUND("Core-Basic-FileCopy: Invalid input file. File not found"),
	FILE_COPY_IO_EXCEPTION("Core-Basic-FileCopy: Cannot perform file operation. I/O Error occured"),
	THREAD_INTERRUPTEDEXCEPTION("Core-Basic-Thread : Thread run interrupted");
	
	private String message;
	
	private LearningExceptions(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}