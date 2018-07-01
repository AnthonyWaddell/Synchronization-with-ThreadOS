// Resources used: https://www.programcreek.com/2009/02/notify-and-wait-example/

import java.util.*;

public class QueueNode
{
	// To hold threads
	private Vector<Integer> thread_queue;
	
	// Constructor
	public QueueNode()
	{
      thread_queue = new Vector<Integer>();
	}
	
	// A thread can put itself to sleep inside the monitor by obtaining the 
	// monitor with the synchronized keyword and calling the wait() method
	public synchronized int sleepSignal()
	{
    int size = thread_queue.size();
		int ret_val = -1;
		if(size == 0)
		{
			try
			{
				System.out.println("Waiting for thread to complete");
				wait();
			} catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			ret_val = thread_queue.remove(0);
			return ret_val;
		}
		return ret_val;
		
	}
	
	// A thread can be signaled and woken-up by obtaining the monitor and 
	// calling calling the notify() method
	public synchronized void wakeSignal(int tid)
	{
		thread_queue.add(tid);
		notify();
	}
}
