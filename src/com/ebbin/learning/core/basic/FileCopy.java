package com.ebbin.learning.core.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.ebbin.learning.exception.LearningException;
import com.ebbin.learning.exception.types.LearningExceptions;
import com.ebbin.learning.run.Run;

public class FileCopy implements Run {
	
	private final String outputFileName = "OutputFile.txt";

	@Override
	public void runApp() throws LearningException {
		
		try {
			copyFile(generateAbsoluteFilePath("SourceFile.txt"));
		}
		catch(FileNotFoundException fe) {
			throw new LearningException(LearningExceptions.FILE_COPY_FILE_NOT_FOUND, fe.getCause());
		}
		catch(IOException ioe) {
			throw new LearningException(LearningExceptions.FILE_COPY_IO_EXCEPTION, ioe.getCause());
		}
	}
	
	/**
	 * @author Ebbin
	 * Method to copy contents of source file to newly created file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @param <String> sourceFileName: The name of the file to be copied
	 */
	public void copyFile(String sourceFileName) throws FileNotFoundException, IOException{
		
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		
		try {
			fileReader = new FileReader(sourceFileName);
			fileWriter = new FileWriter(generateAbsoluteFilePath(outputFileName));
			int ch;
			
			while((ch = fileReader.read()) != -1) {
				fileWriter.write(ch);
			}
		}
		finally {
			if(fileReader != null) {
				fileReader.close();
			}
			if(fileWriter != null) {
				fileWriter.close();
			}
		}
	}
	
	private String generateAbsoluteFilePath(String fileName) {
		
		String workingDirectory = System.getProperty("user.dir");
		
		String filePath = workingDirectory + File.separator + "src" + File.separator + "com" + File.separator + "ebbin"
							+ File.separator + "learning" + File.separator + "resources" + File.separator + "core"
							+ File.separator + "basic" + File.separator + "filecopy" + File.separator + fileName;
		
		return filePath;
	}
	
}
