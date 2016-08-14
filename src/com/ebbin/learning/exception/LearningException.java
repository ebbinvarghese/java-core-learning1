package com.ebbin.learning.exception;

import com.ebbin.learning.exception.types.LearningExceptions;

public class LearningException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public LearningException(LearningExceptions type) {
		super(type.getMessage());
	}
	
	public LearningException(LearningExceptions type, Throwable t) {
		super(type.getMessage(), t);
	}

}
