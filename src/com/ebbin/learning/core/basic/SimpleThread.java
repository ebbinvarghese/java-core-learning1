package com.ebbin.learning.core.basic;

import com.ebbin.learning.exception.LearningException;
import com.ebbin.learning.exception.types.LearningExceptions;
import com.ebbin.learning.run.Run;



public class SimpleThread extends Thread implements Run{

	@Override
	public void runApp() throws LearningException {
		try
		{
			simpleThreadMethod();	
		}
		catch(InterruptedException | IllegalThreadStateException ie)
		{
			throw new LearningException(LearningExceptions.THREAD_INTERRUPTEDEXCEPTION, ie.getCause());
		}
	}
	/**
	 * 
	 * Method to run two thread objects and print the values,also used sleep method to sleep a thread for a specified time,
	 * also sets priority for threads
	 * @author Akhil
	 * @throws InterruptedException,IllegalThreadStateException
	 * @see link http://www.tutorialspoint.com/java/java_multithreading.htm
	 */
	private void simpleThreadMethod() throws InterruptedException,IllegalThreadStateException
	{
		
		SimpleThread thread1_obj = new SimpleThread();
		SimpleThread thread2_obj = new SimpleThread();

		thread1_obj.setPriority(MIN_PRIORITY);//value : 1
		thread2_obj.setPriority(MAX_PRIORITY);//value : 10
		
		thread1_obj.setName("first thread");
		thread2_obj.setName("second : max prio thread");
		
		thread1_obj.start();
		thread2_obj.start();
//		thread1_obj.start(); not possible to start again : IllegalThreadStateException
	}
	//TODO change exception methods
	public void run()
	{
		int sleepMilliSeconds = 500;
		for(int i=1;i<5;i++)
		{
			System.out.println("current thread name:"+Thread.currentThread().getName());
			System.out.println("value in  loop : "+i);
			try
			{
				Thread.sleep(sleepMilliSeconds);
				
			} catch (InterruptedException  | IllegalThreadStateException e)
			{
				e.printStackTrace();
			}
			
		}
	}

}
