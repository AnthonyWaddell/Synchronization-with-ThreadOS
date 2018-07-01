// Simple test class that performs a CPU intensive task to
// to test performance improvement by allowing threads to sleep
// on disk operations. 

import java.util.*;

public class TestThread3a extends Thread
{
	// Basic constructor
	public TestThread3a()
	{
		
	}
	
	// Always want a run ¯\_(ツ)_/¯
	public void run()
	{
		SysLib.cout("Testing TestThread3a\n");
		
		int wasteful = 0;
		// Let's make it really intense
		for(int i = 0; i < 100; i++)
		{
			// No, I mean REALLY intense
			for(int j = 0; j < 100; j++)
			{
				wasteful = recursive_fibonacci(70);  
			}		
		}
		SysLib.exit();
	}
	
	// Simple function to abuse the CPU
	public int recursive_fibonacci(int n)  
	{
		if(n == 0)
		{
			return 0;
		}
		else if(n == 1)
		{
			return 1;
		}
		else
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
