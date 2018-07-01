// Write a user-level test thread called Test3.java which spawns and waits
// for the completion of X pairs of threads (where X = 1 ~ 4), one 
// conducting only numerical computation and the other reading/writing 
// many blocks randomly across the disk.
// Resources used: http://users.cms.caltech.edu/~donnie/cs11/java/java-main.html
import java.lang.*; // to track the thread completion time

public class Test3 extends Thread
{
	// The number of thread pairs to test
	private int pairCount;
	
	// Constructor that takes command line arg for number of thread pairs
	public Test3(String[] args)
	{
		pairCount = Integer.parseInt(args[0]);
	}
	
	// Always want a run ¯\_(ツ)_/¯
	public void run()
	{
		// For tracking completion time
		long startTime = 0L;
		long finishTime = 0L;
		long totalTime = 0L;
		
		// Start tracking the completion time 
		startTime = System.currentTimeMillis();
		SysLib.cout("Beginning Test Threads 3a && 3b\n");
		//Test TestThread3a.java for CPU-intensive operations
		for(int i = 0; i < pairCount; i++)
		{
			SysLyb.exec(SysLib.stringToArgs("TestThread3a"));
		}
		
		//Test TestThread3b.java for I/O-intensive operations
		for(int i = 0; i < pairCount; i++)
		{
			SysLyb.exec(SysLib.stringToArgs("TestThread3b"));
		}
		
		// Stop tracking completion time and output to console
		finishTime = System.currentTimeMillis();
		totalTime = (finishTime - startTime);
		SysLib.cout("Test3 took: " + totalTime + "milliseconds\n");
		
		// Exit
		SysLib.exit();
	}
}